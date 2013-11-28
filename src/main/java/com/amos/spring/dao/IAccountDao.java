package com.amos.spring.dao;

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

}
