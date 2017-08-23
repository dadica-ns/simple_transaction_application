package com.iktpreobuka.banking.services;

import java.util.List;

import com.iktpreobuka.banking.entities.TransactionEntity;
import com.iktpreobuka.banking.entities.dto.TransactionDto;

public interface TransactionService {
	
	TransactionEntity create (TransactionDto transaction);
	List<TransactionEntity> findByClientId (Integer id);

}
