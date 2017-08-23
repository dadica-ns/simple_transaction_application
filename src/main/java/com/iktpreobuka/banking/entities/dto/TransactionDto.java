package com.iktpreobuka.banking.entities.dto;


public class TransactionDto {
	
	private Double ammount;
	private Integer toAccount;
	private Integer fromAccount;
	
	
	public TransactionDto() {
		super();
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	public Integer getToAccount() {
		return toAccount;
	}
	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}
	public Integer getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}
	
	
	

}

