package com.iktpreobuka.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking.entities.TransactionEntity;
import com.iktpreobuka.banking.entities.dto.TransactionDto;
import com.iktpreobuka.banking.repositories.TransactionRepository;
import com.iktpreobuka.banking.services.TransactionService;

@RestController
@RequestMapping (path = "/api/v1/transaction")
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@RequestMapping (method = RequestMethod.GET)
	public List<TransactionEntity> getAll(){
		return (List<TransactionEntity>) transactionRepository.findAll();
	}
	@RequestMapping (method = RequestMethod.GET, value = "/{clientId}")
	public List<TransactionEntity> getTransactionByClient(@PathVariable Integer clientId){
		return transactionService.findByClientId(clientId);
	}
	@RequestMapping (method = RequestMethod.POST)
	public TransactionEntity addNewTransaction (@RequestBody TransactionDto transaction){
		TransactionEntity newTran = transactionService.create(transaction);
		return newTran;
		
	}
	@RequestMapping (method = RequestMethod.DELETE)
	public List<TransactionEntity> deleteAll (){
		List<TransactionEntity> trans = (List<TransactionEntity>) transactionRepository.findAll();
		transactionRepository.delete(trans);
		return trans;
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/{id}")
	public TransactionEntity delete (@PathVariable Integer id){
		TransactionEntity tran = transactionRepository.findOne(id);
		transactionRepository.delete(tran);
		return tran;
		
	}
	
	
}