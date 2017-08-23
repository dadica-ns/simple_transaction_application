package com.iktpreobuka.banking.services;

import com.iktpreobuka.banking.entities.ClientEntity;
import com.iktpreobuka.banking.entities.dto.ClientDto;

public interface ClientService {
	
	ClientEntity updateClient (Integer clientId, ClientDto client);
}
