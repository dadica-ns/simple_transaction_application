package com.iktpreobuka.banking.services;

import java.util.List;

import com.iktpreobuka.banking.entities.ClientEntity;

public interface BanksClients {
	
	List<ClientEntity> findClientsByBankId (Integer id);

}
