package com.amos.spring.dao;

import java.util.List;

import com.amos.spring.model.Account;

public interface IAccountDao {
	
	void save(Account account);

	void update(Long id, Account account);
	
	/*
	 * 根据用户id获取账户信息
	 */
	Account get(Long id);
	/*
	 * 根据name获取账户信息
	 */
	Account get(String name);
	
	List<Account> loadAll();
	/*
	 * 分页查询的支持
	 */
	List<Account> query(String scope,Object[] parameters,int begin,int max);
		
}
