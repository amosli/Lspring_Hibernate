package com.amos.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.amos.spring.model.Account;

/**
 * @ClassName: IAccountDaoImpl
 * @Description: IAccountDao的各方法实现
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 29, 2013 12:59:32 AM
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	public void save(Account account) {

		getJdbcTemplate().update("insert into account(name,balance) values(?,?)", account.getName(), account.getBalance());

	}

	public void update(Long id, Account account) {
		getJdbcTemplate().update("update account set name=?,balance=? where id=?", account.getName(), account.getBalance(), id);

	}

	public Account get(Long id) {
		return getJdbcTemplate().queryForObject("select * from account where id=?", new AccountRowMapper(), id);

	}

	public Account get(String name) {
		List<Account> list = getJdbcTemplate().query("select * from account where name=?", new AccountRowMapper(), name);
		if (list != null && list.size() > 0)
			return list.get(0);//这里因为取得的值是一个list，这里只是取一个值 
		return null;

	}
	/*
	 * 把实现RowMapper接口的类提取出来
	 */
	private class AccountRowMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setId(rs.getLong("id"));
			account.setName(rs.getString("name"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		}
	};

}
