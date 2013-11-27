package com.amos.spring.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.amos.spring.dao.DbUtil;
import com.amos.spring.dao.IpersonDao;
import com.amos.spring.model.Person;

/**
 * @ClassName: PersonDaoImplJdbcTemplate
 * @Description: 代码继续优化,把实现接口的方法提取出来
 * @author: amosli 
 * @email:amosli@infomorrow.com
 * @date Nov 27, 2013 11:51:06 PM
 */
public class PersonDaoImplJdbcTemplate implements IpersonDao {

	interface UpdateOperation {
		/**
		 * 把各种各样的操作封装成一个接口
		 * 
		 * @param stmt
		 * @throws SQLException
		 */
		void execute(Statement stmt) throws SQLException;
	}

	/**
	 * 执行数据库操作
	 */
	public void excuteUpdate(UpdateOperation operation) {
		// 获得一个连接Connection
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbUtil.getConn();
			// 开取事务
			conn.setAutoCommit(false);
			// 初始化相关的Statment对象
			stmt = conn.createStatement();
			// 执行具体的操作
			operation.execute(stmt);
			// 提交事务
			conn.commit();
		} catch (Exception e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DbUtil.close(null, stmt, conn);
		}
	}

	public void excuteSql(final String sql) {
		excuteUpdate(new UpdateOperation() {
			public void execute(Statement stmt) throws SQLException {
				stmt.executeUpdate(sql);
			}
		});
	}

	public void save(final Person p) {
		// save中就只有核心的业务代码了
		String sql = "insert into person(name,age) values('" + p.getName() + "'," + p.getAge() + ")";
		excuteSql(sql);
	}

	public void update(final Long id, final Person p) {
		String sql = "update person set name = '" + p.getName() + "',age='" + p.getAge() + "' where id='" + id + "'";
		excuteSql(sql);
	}

	public void delete(final Long id) {
		String sql = "delete person where id='" + id + "'";
		excuteSql(sql);
	}

	public List<Person> loadAll() {
		return null;
	}

}
