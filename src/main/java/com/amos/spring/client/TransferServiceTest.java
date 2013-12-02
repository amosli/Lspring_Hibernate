package com.amos.spring.client;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.amos.spring.dao.AccountDaoByHibernate;
import com.amos.spring.dao.IAccountDao;
import com.amos.spring.model.Account;
import com.amos.spring.service.ITransferService;

/**
 * @ClassName: TransferServiceTest
 * @Description: spring transaciton,转账示例
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 29, 2013 12:45:33 AM
 */
public class TransferServiceTest {
//	@Test
	public void saveMoney() {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		service.saveMoney("a", 100d);
		service.saveMoney("b", 100d);
	}
//	@Test
	public void takeMoney() {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		service.takeMoney("a", 100d);
		service.takeMoney("b", 100d);
	}
//	@Test
	public void transferMoney() {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		System.out.println(service.getClass());
		service.transferMoney("a", "b", 299d);
	}
//	@Test
	public void hibernateDao(){
		Account a = new Account();
		a.setName("abc");
		a.setBalance(11d);
		IAccountDao dao = new AccountDaoByHibernate();
		dao.save(a);
	}
//	@Test
	public void transferMoneyHibernateOld() {
		/*
		 * 使用hibernate配置文件去调用hibernate
		 */
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction_hibernateold.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		System.out.println(service.getClass());
		service.transferMoney("a", "b", 299d);
	}
//	@Test
	public void transferMoneyHibernateTemplate() {
		/*
		 * 使用Spring提供的hibernateTemplate来调用
		 */
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction_hibernate_template.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		System.out.println(service.getClass());
		service.transferMoney("a", "b", 299d);
	}
	
//	@Test
	public void transferMoneyHibernateDaoSupport() {
		/*
		 * 使用Spring推荐的与hibernate整合的方式来实现DAO和集成  
		 */
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction_hibernate_dao_support.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		System.out.println(service.getClass());
		service.transferMoney("a", "b", 299d);
	}
	
	
}
