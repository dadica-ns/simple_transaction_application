package com.iktpreobuka.banking.entities.dto;

public class BankDto {

	private Integer idAtNBS;
	private String pib;
	private String name;
	private String street;
	private String city;
	private String country;
	
	public BankDto() {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	
}
