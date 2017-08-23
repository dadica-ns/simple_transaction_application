package com.iktpreobuka.banking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"clients","banks"})
public class AddressEntity {

		
		@Id
		@GeneratedValue
		private Integer id;
		
		private String street;
		private String city;
		private String country;
				
		
		@JsonBackReference(value ="client address")
		@OneToMany(mappedBy = "address", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		private List<ClientEntity> clients = new ArrayList<>();
		
		@JsonBackReference (value = "banks address")
		@OneToMany(mappedBy = "bankAddress", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		private List<BankEntity> banks = new ArrayList<>();
		
		@Version
		private Integer version;

		public AddressEntity() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Integer getVersion() {
			return version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}
		
		public List<ClientEntity> getClients() {
			return clients;
		}

		public void setClients(List<ClientEntity> clients) {
			this.clients = clients;
		}

		public List<BankEntity> getBanks() {
			return banks;
		}

		public void setBanks(List<BankEntity> banks) {
			this.banks = banks;
		}

		
		
		

}
