package com.amos.spring.service;

import java.util.List;

import com.amos.spring.dao.IAccountDao;
import com.amos.spring.model.Account;

/**
 * @ClassName: TransferServiceImpl
 * @Description: 实现账户转账的接口
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 29, 2013 1:25:27 AM
 */
public class TransferServiceImpl2 implements ITransferService {
	private IAccountDao accountDao;

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void saveMoney(String name, Double money) {
		// 先查账户是否存在
		Account account = getAccount(name);
		if (account == null) {
			// 不存在,第一次存钱
			account = new Account();
			account.setName(name);
			account.setBalance(money);
			accountDao.save(account);// 将数据写入数据库
		} else {
			account.setBalance(account.getBalance() + money);// 加上之前的余额
			accountDao.update(account.getId(), account);// 更新数据库的值
		}
	}
	public Account getAccount(String name){
		List<Account> list = accountDao.query("name=?", new Object[]{name}, 0, 1);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	public void takeMoney(String name, Double money) {
		Account account = getAccount(name);
		if (account == null) {
			throw new LogicException("此账户不存在!");
		}
		if (account.getBalance() < money) {
			throw new LogicException("余额不足!");
		}
		account.setBalance(account.getBalance() - money);
		accountDao.update(account.getId(), account);
	}

	public void transferMoney(String from, String to, Double money) {
		if (getAccount(to) == null) {
			throw new LogicException("目标账户不存在!");
		}
		// 先从from账上取钱
		takeMoney(from, money);
		// 去除手续费
		takeMoney(from, money * 0.1);
		// 把钱存到to账上
		saveMoney(to, money);
	}

}
