package com.amos.spring.model;

/**
 * @ClassName: Account
 * @Description: 账户
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 29, 2013 12:46:41 AM
 */
public class Account {
	private Long id;
	private String name;
	private Double balance;//余额

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
