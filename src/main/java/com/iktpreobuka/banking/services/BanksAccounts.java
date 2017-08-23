package com.iktpreobuka.banking.services;

import java.util.List;

import com.iktpreobuka.banking.entities.AccountEntity;

public interface BanksAccounts {
	
	List<AccountEntity> findAccountByBankId(Integer bankId);

}
