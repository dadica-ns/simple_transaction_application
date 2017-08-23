package com.iktpreobuka.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.AccountEntity;
import com.iktpreobuka.banking.entities.BankEntity;
import com.iktpreobuka.banking.entities.ClientEntity;
import com.iktpreobuka.banking.entities.dto.ClientDto;
import com.iktpreobuka.banking.repositories.AccountRepository;
import com.iktpreobuka.banking.repositories.BankRepository;
import com.iktpreobuka.banking.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public ClientEntity updateClient (Integer clientId, ClientDto client) {
		ClientEntity clientDB = clientRepository.findOne(clientId);
		
		List<AccountEntity> accounts = accountService.findAccountByClientId(clientId);
		AccountEntity newAccount = new AccountEntity();
		
		BankEntity existingBank = bankRepository.findByIdAtNBSAndPibAndName(client.getIdAtNBS(), client.getPib(), client.getBankName());
		
		if(client.getName() != null){
			clientDB.setName(client.getName());
			}
			if(client.getLastName() != null){
			clientDB.setLastName(client.getLastName());
			}
			if(client.getBrojLicneKarte() != null){
			clientDB.setBrojLicneKarte(client.getBrojLicneKarte());
			}
			if(client.getEmail() != null){
			clientDB.setEmail(client.getEmail());
			}
			if(client.getJMBG() != null){
			clientDB.setJMBG(client.getJMBG());
			}
			if(client.getPhoneNumber() != null){
			clientDB.setPhoneNumber(client.getPhoneNumber());
			}
			
			
			if(client.getAccountType() != null && client.getAccountNumber() != null){
				newAccount.setAccountType(client.getAccountType());
				newAccount.setAccountNumber(client.getAccountNumber());
				newAccount.setBalance(client.getBalance());
			}
			newAccount.setOwner(clientDB);
			newAccount.setBankOwner(existingBank);
			clientDB.setBank(existingBank);
			
			accounts.add(newAccount);
			accountRepository.save(newAccount);
			clientDB.setAccounts(accounts);
			clientRepository.save(clientDB);
					
		return clientDB;
	}

}
