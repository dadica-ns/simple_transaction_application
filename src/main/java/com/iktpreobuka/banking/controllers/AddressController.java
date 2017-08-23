package com.iktpreobuka.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking.entities.AddressEntity;
import com.iktpreobuka.banking.repositories.AddressRepository;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	/*@RequestMapping(method = RequestMethod.POST)
	public AddressEntity saveAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();

		address.setStreet(street);
		address.setCountry(country);
		address.setCity(city);
		addressRepository.save(address);

		return address;
	}*/
	@RequestMapping (method = RequestMethod.POST)
	public AddressEntity saveAddress(@RequestBody AddressEntity address){
		addressRepository.save(address);
		return address;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<AddressEntity> getAll() {
		List<AddressEntity> addresses = (List<AddressEntity>) addressRepository.findAll();
		return addresses;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{addressId}")
	public AddressEntity getAddressById(@PathVariable Integer addressId) {
		return addressRepository.findOne(addressId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{addressId}")
	public AddressEntity updateAddress(@PathVariable Integer addressId, @RequestParam String street,
			@RequestParam String city, @RequestParam String country) {
		AddressEntity address = addressRepository.findOne(addressId);

		if (street != null) {
			address.setStreet(street);
		}
		if (city != null) {
			address.setCity(city);
		}
		if (country != null) {
			address.setCountry(country);
		}
		addressRepository.save(address);
		return address;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{addressId}")
	public AddressEntity deleteAddress(@PathVariable Integer addressId) {
		AddressEntity address = addressRepository.findOne(addressId);
		addressRepository.delete(address);
		return address;
	}
	@RequestMapping (value = "/by-city")
	public List<AddressEntity> getByCity (@RequestParam String city){
		return addressRepository.findByCityOrderByStreetAsc(city);
	}
	@RequestMapping (value = "/by-all")
	public AddressEntity findByAll(@RequestParam String street, @RequestParam String city, @RequestParam String country){
		return addressRepository.findByStreetAndCityAndCountry(street, city, country);
	}

}
