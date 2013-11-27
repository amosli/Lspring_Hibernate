package com.amos.spring.impl;

import java.util.List;

import com.amos.spring.dao.IpersonDao;
import com.amos.spring.model.Person;

/** 
* @ClassName: PersonDaoImplJdbcTemplateBest 
* @Description: 调用封装好的类
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 28, 2013 12:14:48 AM  
*/
public class PersonDaoImplJdbcTemplateBest implements IpersonDao {
	private MyJdbcTemplate jdbcTemplate;

	public List<Person> loadAll() {
		return null;
	}

	public void save(Person p) {
		String sql = "insert into person(name,age) values('" + p.getName() + "'," + p.getAge() + ")";
		jdbcTemplate.excuteSql(sql);
	}

	public void update(Long id, Person p) {
		String sql = "update person set name = '" + p.getName() + "',age='" + p.getAge() + "' where id='" + id + "'";
		jdbcTemplate.excuteSql(sql);
	}

	public void delete(Long id) {
		String sql = "delete person where id='" + id + "'";
		jdbcTemplate.excuteSql(sql);

	}

}
