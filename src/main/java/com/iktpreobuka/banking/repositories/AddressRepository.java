package com.iktpreobuka.banking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.banking.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
	
	List<AddressEntity> findByCityOrderByStreetAsc (String city);
	AddressEntity findByStreetAndCityAndCountry (String street, String city, String country);

}
