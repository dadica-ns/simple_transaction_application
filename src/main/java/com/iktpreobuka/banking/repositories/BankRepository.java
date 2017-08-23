package com.iktpreobuka.banking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.banking.entities.BankEntity;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {
	
	BankEntity findByIdAtNBSAndPibAndName (Integer idAtNBS, String pib, String name);

}
