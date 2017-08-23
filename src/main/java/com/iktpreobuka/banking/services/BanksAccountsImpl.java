package com.iktpreobuka.banking.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking.entities.AccountEntity;

@Service
public class BanksAccountsImpl implements BanksAccounts {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	//public List<AccountEntity> findAccountByClientName(String name){
	public List<AccountEntity> findAccountByBankId(Integer bankId){
		String sql = "select a from AccountEntity a left join fetch a.bankOwner o where o.id = :id";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", bankId);
		
		List<AccountEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
	}

}
