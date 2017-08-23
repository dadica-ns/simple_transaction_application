package com.iktpreobuka.banking.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.TransactionEntity;

@Service
public class ClientsTransactionsImpl implements ClientsTransactions {
	
	@PersistenceContext
	private EntityManager em;
 
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionEntity> findTransactionByClientId (Integer id) {
		
		String sql = "select t from TransactionEntity t left join fetch t.fromClient c where c.id = :id";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		List<TransactionEntity> result = new ArrayList<>();
		result = query.getResultList();
		
		return result;
	}

}
