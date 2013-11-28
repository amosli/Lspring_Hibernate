package com.amos.spring.client;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		service.saveMoney("a", 300d);
		service.saveMoney("b", 300d);
	}
//	@Test
	public void takeMoney() {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		service.takeMoney("a", 100d);
		service.takeMoney("b", 100d);
	}
	@Test
	public void transferMoney() {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_transaction.xml");
		ITransferService service = acx.getBean(ITransferService.class);
		service.transferMoney("a", "a1", 100d);
	}
}
