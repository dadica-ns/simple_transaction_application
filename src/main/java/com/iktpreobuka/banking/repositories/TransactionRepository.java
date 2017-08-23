package com.iktpreobuka.banking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.banking.entities.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
	
	List<TransactionEntity> findByFromAccountOwnerId(Integer id);
	List<TransactionEntity> findByToAccountOwnerId (Integer id);

}
