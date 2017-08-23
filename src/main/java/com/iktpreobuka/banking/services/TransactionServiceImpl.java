package com.iktpreobuka.banking.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.AccountEntity;
import com.iktpreobuka.banking.entities.TransactionEntity;
import com.iktpreobuka.banking.entities.dto.TransactionDto;
import com.iktpreobuka.banking.repositories.AccountRepository;
import com.iktpreobuka.banking.repositories.TransactionRepository;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {
	

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionEntity create(TransactionDto transaction) {
		
		TransactionEntity newOne = new TransactionEntity();
		newOne.setAmmount(transaction.getAmmount());
		AccountEntity fromAccount = accountRepository.findOne(transaction.getFromAccount());
		AccountEntity toAccount = accountRepository.findOne(transaction.getToAccount());
		
		Double ammount = transaction.getAmmount();
		fromAccount.setBalance(fromAccount.getBalance() - ammount);
		toAccount.setBalance(toAccount.getBalance() + ammount);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		newOne.setToAccount(toAccount);
		newOne.setFromAccount(fromAccount);
		transactionRepository.save(newOne);
		return newOne;		
	}

	@Override
	public List<TransactionEntity> findByClientId(Integer id) {
		List<TransactionEntity> receivedTransactions = transactionRepository.findByToAccountOwnerId(id);
		List<TransactionEntity> sentTransactions = transactionRepository.findByFromAccountOwnerId(id);
		List<TransactionEntity> allTransactions = new ArrayList<>();
		
		for(int i = 0; i < receivedTransactions.size(); i++){
			allTransactions.add(receivedTransactions.get(i));
		}
		for(int i = 0; i < sentTransactions.size(); i++){
			allTransactions.add(sentTransactions.get(i));
		}
		
		return allTransactions;
	}

}
