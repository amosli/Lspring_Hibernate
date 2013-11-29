package com.amos.spring.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amos.spring.dao.IAccountDao;
import com.amos.spring.model.Account;


/** 
* @ClassName: TransferServiceImplAnnotation 
* @Description: 基于注解的声明式事务管理
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 30, 2013 12:31:26 AM  
*/
/*
 * 类前面加@Transactional表示整个业务组件均需要事务
 */
@Transactional
public class TransferServiceImplAnnotation implements ITransferService {
	private IAccountDao accountDao;

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	/*
	 * 新开一个事务， 不管当前有没有事务
	 * @see com.amos.spring.service.ITransferService#saveMoney(java.lang.String, java.lang.Double)
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveMoney(String name, Double money) {
		// 先查账户是否存在
		Account account = accountDao.get(name);
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
	/*
	 * Propagation.NEVER,NOT_SUPPORTED不支持事务，.SUPPORTS表示支持事务，有没有事务均可。
	 * @see com.amos.spring.service.ITransferService#takeMoney(java.lang.String, java.lang.Double)
	 */
	@Transactional(propagation=Propagation.SUPPORTS)
	public void takeMoney(String name, Double money) {
		Account account = accountDao.get(name);
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
		if (accountDao.get(to) == null) {
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
