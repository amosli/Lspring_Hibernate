package com.amos.spring.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amos.spring.model.Person;

public class SpringPersonDaoTest {
	private static IpersonDao dao;
//	@Test
	public static void main(String args[]){
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean.xml");
		dao = acx.getBean(IpersonDao.class);
		Person person = new Person();
		person.setName("运哥");
		person.setAge(33);
		dao.save(person);
	}
}
