package com.iktpreobuka.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking.entities.AccountEntity;
import com.iktpreobuka.banking.repositories.AccountRepository;

@RestController
@RequestMapping ( path = "/api/v1/accounts")
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;	
		
	@RequestMapping (method = RequestMethod.GET)
	public List<AccountEntity> getAll(){
		return (List<AccountEntity>) accountRepository.findAll();
	
	}
	/*@RequestMapping (method = RequestMethod.POST)
	public AccountEntity addNewAccount (@RequestParam String accountType, @RequestParam Integer accountNumber, @RequestParam Double balance, @RequestParam Integer clientId){
		AccountEntity account = new AccountEntity();
		ClientEntity owner = clientRepository.findOne(clientId);
		
		account.setAccountType(accountType);
		account.setAccountNumber(accountNumber);
		account.setBalance(balance);
		account.setOwner(owner);
		
		accountRepository.save(account);
		return account;
	}
	@RequestMapping (method = RequestMethod.PUT, value = "/{accountId}")
	public AccountEntity updateAccount (@PathVariable Integer accountId, @RequestParam String accountType, @RequestParam Integer accountNumber, @RequestParam Double balance, @RequestParam Integer clientId){
		AccountEntity account = accountRepository.findOne(accountId);
		ClientEntity owner = clientRepository.findOne(clientId);
		if(accountType != null){
			account.setAccountType(accountType);
		}
		if(accountNumber != null){
			account.setAccountNumber(accountNumber);
		}
		if(balance != null){
			account.setBalance(balance);
		}
		if(clientId != null){
			account.setOwner(owner);
		}
		accountRepository.save(account);
		return account;		
	}*/
	@RequestMapping (method = RequestMethod.DELETE, value = "/{accountId}")
	public AccountEntity deleteAccount (@PathVariable Integer accountId){
		AccountEntity account = accountRepository.findOne(accountId);
		accountRepository.delete(account);
		return account;
	}
	
}
