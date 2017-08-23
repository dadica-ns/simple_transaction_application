package com.iktpreobuka.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking.entities.AccountEntity;
import com.iktpreobuka.banking.entities.AddressEntity;
import com.iktpreobuka.banking.entities.BankEntity;
import com.iktpreobuka.banking.entities.ClientEntity;
import com.iktpreobuka.banking.entities.dto.BankDto;
import com.iktpreobuka.banking.repositories.AccountRepository;
import com.iktpreobuka.banking.repositories.AddressRepository;
import com.iktpreobuka.banking.repositories.BankRepository;
import com.iktpreobuka.banking.repositories.ClientRepository;
import com.iktpreobuka.banking.services.BanksAccounts;
import com.iktpreobuka.banking.services.BanksClients;

@RestController
@RequestMapping (path = "/api/v1/banks")
@CrossOrigin
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BanksAccounts banksAccounts;
	
	@Autowired
	private BanksClients banksClients;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getanks() {
		return new ResponseEntity<List<BankEntity>>((List<BankEntity>) bankRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{bankId}")
	public ResponseEntity<?> getBankById(@PathVariable Integer bankId) {
		BankEntity bank = bankRepository.findOne(bankId);
		return new ResponseEntity<BankEntity>(bank, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveBank(@RequestBody BankDto newBank) {
		BankEntity bank = new BankEntity();
		AddressEntity address = new AddressEntity();
		AddressEntity existingAddress = addressRepository.findByStreetAndCityAndCountry(newBank.getStreet(), newBank.getCity(), newBank.getCountry());
		
		bank.setIdAtNBS(newBank.getIdAtNBS());
		bank.setPib(newBank.getPib());
		bank.setName(newBank.getName());
		
		if(existingAddress != null){
			bank.setBankAddress(existingAddress);
		}
		
		else {
		address.setStreet(newBank.getStreet());
		address.setCity(newBank.getCity());
		address.setCountry(newBank.getCountry());
		addressRepository.save(address);
		bank.setBankAddress(address);
		}
		bankRepository.save(bank);
		return new ResponseEntity<BankEntity>(bank, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{bankId}")
	public ResponseEntity<?> updateBank(@PathVariable Integer bankId, @RequestBody BankDto bank) {
		BankEntity bankDB = bankRepository.findOne(bankId);
		bankDB.setIdAtNBS(bank.getIdAtNBS());
		bankDB.setPib(bank.getPib());
		bankDB.setName(bank.getName());
		
		bankRepository.save(bankDB);
		return new ResponseEntity<BankEntity>(bankDB, HttpStatus.OK);
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/{bankId}")
	public ResponseEntity<?> deleteBank(@PathVariable Integer bankId){
		BankEntity bank = bankRepository.findOne(bankId);
		List<AccountEntity> accounts = banksAccounts.findAccountByBankId(bankId);
		List<ClientEntity> clients = banksClients.findClientsByBankId(bankId);
		accountRepository.delete(accounts);
		clientRepository.delete(clients);
		
		bankRepository.delete(bank);
		return new ResponseEntity<BankEntity>(bank, HttpStatus.OK);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/{bankId}/accounts")
	public List<AccountEntity> getAccounts (@PathVariable Integer bankId){
		return banksAccounts.findAccountByBankId(bankId);
		
	}
	@RequestMapping (method = RequestMethod.GET, value = "/{bankId}/clients")
	public List<ClientEntity> getClients (@PathVariable Integer bankId){
		return banksClients.findClientsByBankId(bankId);
		
	}
	
	

}
