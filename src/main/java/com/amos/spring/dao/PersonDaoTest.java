package com.amos.spring.dao;

import com.amos.spring.impl.PersonDaoImplJdbcTemplateBest;
import com.amos.spring.model.Person;

public class PersonDaoTest {
	private static IpersonDao dao;
//	@Test
	public static void main(String args[]){
//	public void addPerson(){
		dao = new PersonDaoImplJdbcTemplateBest();
//		PersonDaoImplJdbcOld dao1 = new PersonDaoImplJdbcOld();
		Person person = new Person();
		person.setName("运哥");
		person.setAge(29);
//		dao1.save(person);
		dao.save(person);
	}
}
