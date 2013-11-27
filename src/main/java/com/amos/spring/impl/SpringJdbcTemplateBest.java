package com.amos.spring.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.amos.spring.dao.IpersonDao;
import com.amos.spring.model.Person;

/** 
* @ClassName: SpringJdbcTemplateBest 
* @Description: 使用spring 框架进行操作数据库
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 28, 2013 1:01:27 AM  
*/
public class SpringJdbcTemplateBest implements IpersonDao {
	private JdbcTemplate jdbcTemplate;
	public List<Person> loadAll() {
		return null;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Person p) {
		String sql = "insert into person(name,age) values('" + p.getName() + "'," + p.getAge() + ")";
		System.out.println("save:" + sql);
		jdbcTemplate.update(sql);
	}

	public void update(Long id, Person p) {
		String sql = "update person set name = '" + p.getName() + "',age='" + p.getAge() + "' where id='" + id + "'";
		jdbcTemplate.update(sql);
	}

	public void delete(Long id) {
		String sql = "delete person where id='" + id + "'";
		jdbcTemplate.update(sql);
	}

}
