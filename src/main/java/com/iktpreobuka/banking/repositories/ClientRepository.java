package com.iktpreobuka.banking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.banking.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

	ClientEntity findByName (String name);

}
