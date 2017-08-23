package com.iktpreobuka.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking.entities.AccountEntity;
//import com.iktpreobuka.banking.entities.AccountEntity;
import com.iktpreobuka.banking.entities.AddressEntity;
import com.iktpreobuka.banking.entities.ClientEntity;
import com.iktpreobuka.banking.entities.TransactionEntity;
//import com.iktpreobuka.banking.entities.TransactionEntity;
import com.iktpreobuka.banking.entities.dto.ClientDto;
import com.iktpreobuka.banking.repositories.AccountRepository;
//import com.iktpreobuka.banking.repositories.AccountRepository;
import com.iktpreobuka.banking.repositories.AddressRepository;
import com.iktpreobuka.banking.repositories.ClientRepository;
import com.iktpreobuka.banking.repositories.TransactionRepository;
//import com.iktpreobuka.banking.services.AccountService;
//import com.iktpreobuka.banking.services.ClientsTransactions;
import com.iktpreobuka.banking.services.AccountService;
import com.iktpreobuka.banking.services.ClientService;
import com.iktpreobuka.banking.services.TransactionService;


@RestController
@RequestMapping (path = "/api/v1/clients")
@CrossOrigin
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private AccountService accountService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	/*@Autowired
	private ClientsTransactions clientsTransactions;*/
	
		
	@RequestMapping (method = RequestMethod.GET)
	public ResponseEntity<?> getAll () {
		return new ResponseEntity<List<ClientEntity>>((List<ClientEntity>) clientRepository.findAll(), HttpStatus.OK);
	
	}	
	@RequestMapping (method = RequestMethod.GET, value = "/{clientId}")
	public ResponseEntity<?> getClientById (@PathVariable Integer clientId){
		ClientEntity client = clientRepository.findOne(clientId);
		return new ResponseEntity<ClientEntity>(client, HttpStatus.OK);
		
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/{clientId}")
	public ClientEntity updateClient (@PathVariable Integer clientId, @RequestBody ClientDto client){
		return clientService.updateClient(clientId, client);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createClient (@RequestBody ClientDto newClient){
		ClientEntity client = new ClientEntity();
		AddressEntity address = new AddressEntity();
		AddressEntity existingAddress = addressRepository.findByStreetAndCityAndCountry(newClient.getStreet(), newClient.getCity(), newClient.getCountry());
				
		client.setName(newClient.getName());
		client.setLastName(newClient.getLastName());
		client.setEmail(newClient.getEmail());
		client.setJMBG(newClient.getJMBG());
		client.setPhoneNumber(newClient.getPhoneNumber());
		client.setBrojLicneKarte(newClient.getBrojLicneKarte());
		
		if(existingAddress != null){
			client.setAddress(existingAddress);
		}
		else {
		address.setStreet(newClient.getStreet());
		address.setCity(newClient.getCity());
		address.setCountry(newClient.getCountry());
		
		addressRepository.save(address);
		client.setAddress(address);
		}		
		clientRepository.save(client);
		return  new ResponseEntity<ClientEntity>(client, HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public ResponseEntity<?> deleteClient (@PathVariable Integer clientId) {
		
		ClientEntity client = clientRepository.findOne(clientId);
		
		List<AccountEntity> accounts = accountService.findAccountByClientId(clientId);
		List<TransactionEntity> trans = transactionService.findByClientId(clientId);
		accountRepository.delete(accounts);
		transactionRepository.delete(trans);
		
		clientRepository.delete(clientId);
		
		return new ResponseEntity<ClientEntity> (client, HttpStatus.OK);
	}	
	
		
	/*@RequestMapping (method = RequestMethod.GET, value = "/{clientId}/transactions")
	public List<TransactionEntity> findTransactionsByClient (@PathVariable Integer clientId){
		return clientsTransactions.findTransactionByClientId(clientId);
	}*/
	
	@RequestMapping (method = RequestMethod.GET, value = "/{clientId}/accounts")
	public List<AccountEntity> getAccounts (@PathVariable Integer clientId){
		return accountService.findAccountByClientId(clientId);
		
	}
	@RequestMapping (method = RequestMethod.GET, value = "/{clientId}/transaction")
	public List<TransactionEntity> getTransactions (@PathVariable Integer clientId){
		return transactionService.findByClientId(clientId);
		
	}
	
	

}
