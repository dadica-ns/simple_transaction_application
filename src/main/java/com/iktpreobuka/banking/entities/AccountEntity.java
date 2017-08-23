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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"owner"})

public class AccountEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String accountType;
	private Integer accountNumber;
	private Double balance;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="owner")
	private ClientEntity owner;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="bankOwner")
	private BankEntity bankOwner;
	
	@JsonBackReference
	@OneToMany(mappedBy="fromAccount", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TransactionEntity> sentTransactions = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy="toAccount", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<TransactionEntity> receivedTransactions = new ArrayList<>();
	
	@Version
	private Integer version;
	
	public AccountEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public ClientEntity getOwner() {
		return owner;
	}
	public void setOwner(ClientEntity owner) {
		this.owner = owner;
	}
	public BankEntity getBankOwner() {
		return bankOwner;
	}
	public void setBankOwner(BankEntity bankOwner) {
		this.bankOwner = bankOwner;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public List<TransactionEntity> getSentTransactions() {
		return sentTransactions;
	}
	public void setSentTransactions(List<TransactionEntity> sentTransactions) {
		this.sentTransactions = sentTransactions;
	}
	public List<TransactionEntity> getReceivedTransactions() {
		return receivedTransactions;
	}
	public void setReceivedTransactions(List<TransactionEntity> receivedTransactions) {
		this.receivedTransactions = receivedTransactions;
	}
	
	
	
	
	
	
	
	
	
	

}
