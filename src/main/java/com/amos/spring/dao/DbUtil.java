package com.amos.spring.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/** 
* @ClassName: 传统的操作数据库的方式  
* @Description: TODO
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 28, 2013 2:03:23 AM  
*/
public class DbUtil {
	private static DataSource datasource;
	static {
		// 初始化连接池
		BasicDataSource dSource = new BasicDataSource();
		// 设置连接池的属性
		dSource.setDriverClassName("com.mysql.jdbc.Driver");
		dSource.setUrl("jdbc:mysql:///spring_learn");
		dSource.setUsername("root");
		dSource.setPassword("root");
		datasource = dSource;
	}

	public static Connection getConn() throws SQLException {
		return datasource.getConnection();
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}