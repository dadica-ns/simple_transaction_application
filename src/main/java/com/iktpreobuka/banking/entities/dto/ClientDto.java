package com.iktpreobuka.banking.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDto {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastName")
	private String lastName;
	private Integer brojLicneKarte;
	@JsonProperty("jmbg")
	private String JMBG;
	private String email;
	private String phoneNumber;
	private String street;
	private String city;
	private String country;
	
	private Integer idAtNBS;
	private String pib;
	private String bankName;
	
	private String accountType;
	private Integer accountNumber;
	private Double balance;
	
	public ClientDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(Integer brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	

	public Integer getIdAtNBS() {
		return idAtNBS;
	}

	public void setIdAtNBS(Integer idAtNBS) {
		this.idAtNBS = idAtNBS;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	

	public String getAccountType() {
		return accountType;
	}

	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
	
	
	

}
