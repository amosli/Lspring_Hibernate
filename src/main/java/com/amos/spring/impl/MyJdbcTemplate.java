package com.amos.spring.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.amos.spring.dao.DbUtil;

/**
 * @ClassName: PersonDaoImplJdbcTemplate
 * @Description: 代码继续优化,把实现接口的方法提取出来
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 27, 2013 11:51:06 PM
 */
public class MyJdbcTemplate {

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
	public void ExcuteUpdate(UpdateOperation operation) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbUtil.getConn();
			// 开取事务
			conn.setAutoCommit(false);
			// 初始化相关的Statment对象
			stmt = conn.createStatement();
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
	public void excuteUpdate2(UpdateOperation operation) {
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
		ExcuteUpdate(new UpdateOperation() {
			public void execute(Statement stmt) throws SQLException {
				stmt.executeUpdate(sql);
			}
		});
	}

}
