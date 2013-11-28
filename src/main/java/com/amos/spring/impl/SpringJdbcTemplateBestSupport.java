package com.amos.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.amos.spring.dao.IpersonDao;
import com.amos.spring.model.Person;

/**
 * @ClassName: SpringJdbcTemplateBestSupport
 * @Description: 我使用springJdbcDaoSupport来获取 jdbcTemplate，模板技术
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 28, 2013 11:28:00 PM
 */
public class SpringJdbcTemplateBestSupport extends JdbcDaoSupport implements IpersonDao {

	public void save(Person p) {
		//使用spring的jdbc Mapping工具，简化jdbc的调用 
		String sql = "insert into person(name,age) values('" + p.getName() + "'," + p.getAge() + ")";
		System.out.println("save:" + sql);
		getJdbcTemplate().update(sql);
	}

	public void update(Long id, Person p) {
		String sql = "update person set name = '" + p.getName() + "',age='" + p.getAge() + "' where id='" + id + "'";
		getJdbcTemplate().update(sql);
	}

	public void delete(Long id) {
		String sql = "delete person where id='" + id + "'";
		getJdbcTemplate().update(sql);
	}

	@SuppressWarnings("unchecked")
	public Person get(Long id) {
		getJdbcTemplate().queryForObject("select * from person where id=?", new RowMapper() {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getLong("id"));
				person.setAge(rs.getInt("age"));
				person.setName(rs.getString("name"));

				return person;
			}
		}, id);

		return null;  

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Person> loadAll() {
		return getJdbcTemplate().query("select * from person", new RowMapper() {
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getLong("id"));
				person.setAge(rs.getInt("age"));
				person.setName(rs.getString("name"));
				return person;
			}
		});
	}

}
