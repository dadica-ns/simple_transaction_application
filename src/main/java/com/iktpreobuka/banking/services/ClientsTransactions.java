package com.iktpreobuka.banking.services;

import java.util.List;

import com.iktpreobuka.banking.entities.TransactionEntity;

public interface ClientsTransactions {
	
	public List<TransactionEntity> findTransactionByClientId (Integer id);

}
