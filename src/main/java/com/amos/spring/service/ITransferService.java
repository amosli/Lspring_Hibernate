package com.amos.spring.service;

/**
 * @ClassName: ITransferService
 * @Description:账户业务接口
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 29, 2013 12:50:26 AM
 */
public interface ITransferService {
	void saveMoney(String name, Double money);//存钱

	void takeMoney(String name, Double money);//取钱 

	void transferMoney(String from, String to, Double money);//转账

}
