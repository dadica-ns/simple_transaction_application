package com.iktpreobuka.banking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.banking.entities.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
	
	
}
