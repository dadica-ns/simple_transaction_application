package com.iktpreobuka.banking.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.ClientEntity;

@Service
public class BanksClientsImpl implements BanksClients {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientEntity> findClientsByBankId(Integer id) {
		
		String sql = "select c from ClientEntity c left join fetch c.bank b where b.id = :id";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		List<ClientEntity> result = new ArrayList<>();
		result = query.getResultList();
		
		return result;
	}

}
