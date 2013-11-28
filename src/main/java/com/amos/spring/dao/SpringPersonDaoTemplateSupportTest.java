package com.amos.spring.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amos.spring.model.Person;

public class SpringPersonDaoTemplateSupportTest {
	private static IpersonDao dao;
	public static void main(String args[]){
		@SuppressWarnings("resource")
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_template.xml");
		dao = acx.getBean(IpersonDao.class);
		Person person = new Person();
		person.setName("运哥");
		person.setAge(55);
		dao.save(person);
		System.out.println(dao.loadAll());
	}
}
