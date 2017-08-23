
package com.iktpreobuka.banking.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.AccountEntity;

@Service
public class AccountServiceImpl implements AccountService {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	//public List<AccountEntity> findAccountByClientName(String name){
	public List<AccountEntity> findAccountByClientId(Integer id){
		String sql = "select a from AccountEntity a left join fetch a.owner o where o.id = :id";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		List<AccountEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
	}
	

}
