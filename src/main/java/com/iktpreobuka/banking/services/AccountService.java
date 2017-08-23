package com.iktpreobuka.banking.services;

import java.util.List;

import com.iktpreobuka.banking.entities.AccountEntity;

public interface AccountService {
	
	public List<AccountEntity> findAccountByClientId(Integer id);

}
