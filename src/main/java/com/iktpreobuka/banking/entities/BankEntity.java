package com.iktpreobuka.banking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BankEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer idAtNBS;
	private String pib;
	private String name;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="bankAddress")
	private AddressEntity bankAddress;
	
	@JsonBackReference
	@OneToMany(mappedBy="bank", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ClientEntity> clients = new ArrayList<ClientEntity>();
	
	@JsonBackReference
	@OneToMany(mappedBy="bankOwner", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<AccountEntity> accounts = new ArrayList<AccountEntity>();
	
	@Version
	private Integer version;

	public BankEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public AddressEntity getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(AddressEntity bankAddress) {
		this.bankAddress = bankAddress;
	}

	public List<ClientEntity> getClients() {
		return clients;
	}

	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
	
	


	
	
	

}
