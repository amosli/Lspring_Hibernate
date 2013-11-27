package com.amos.spring.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.amos.spring.dao.DbUtil;
import com.amos.spring.dao.IpersonDao;
import com.amos.spring.model.Person;

/** 
* @ClassName: PersonDaoImplJdbcOld 
* @Description: 最原始的操作
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 28, 2013 12:15:20 AM  
*/
public class PersonDaoImplJdbcOld implements IpersonDao {

	public void save(Person p) {
		// 获得连接
		// 获得一个连接Connection
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbUtil.getConn();
			// 开取事务
			conn.setAutoCommit(false);
			// 初始化相关的Statment对象
			stmt = conn.createStatement();
			String sql = "insert into person(name,age) values('" + p.getName() + "'," + p.getAge() + ")";
			stmt.executeUpdate(sql);
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

	public void update(Long id, Person p) {
		// 获得一个连接Connection
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbUtil.getConn();
			// 开取事务
			conn.setAutoCommit(false);
			// 初始化相关的Statment对象
			stmt = conn.createStatement();
			String sql = "update person set name = '" + p.getName() + "',age='" + p.getAge() + "' where id='" + p.getId() + "'";
			stmt.executeUpdate(sql);
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

	public void delete(Long id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbUtil.getConn();
			// 开取事务
			conn.setAutoCommit(false);
			// 初始化相关的Statment对象
			stmt = conn.createStatement();
			String sql = "delete person where id='"+id+"'";
			stmt.executeUpdate(sql);
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

	public List<Person> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
