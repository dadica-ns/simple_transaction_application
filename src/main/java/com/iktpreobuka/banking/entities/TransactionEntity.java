package com.iktpreobuka.banking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class TransactionEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Double ammount;
		
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="fromAccount")
	private AccountEntity fromAccount;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="toAccount")
	private AccountEntity toAccount;
	
	private String svrhaUplate;
	
	/*@JsonFormat(shape =JsonFormat.Shape.STRING,
			pattern = "dd-MM-yyyy")
	private LocalDate date = LocalDate.now();*/
	
	@Version
	private Integer version;

	public TransactionEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public AccountEntity getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(AccountEntity fromAccount) {
		this.fromAccount = fromAccount;
	}

	public AccountEntity getToAccount() {
		return toAccount;
	}

	public void setToAccount(AccountEntity toAccount) {
		this.toAccount = toAccount;
	}

	public String getSvrhaUplate() {
		return svrhaUplate;
	}

	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	


	


}