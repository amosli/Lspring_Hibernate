package com.amos.spring.dao;

import org.junit.Test;

import com.amos.spring.impl.PersonDaoImplJdbcTemplateBest;
import com.amos.spring.model.Person;

public class PersonDaoTest {
	private IpersonDao dao;
	@Test
	public void addPerson(){
		dao = new PersonDaoImplJdbcTemplateBest();
		Person person = new Person();
		person.setName("运哥");
		person.setAge(23);
		dao.save(person);
	}
}
