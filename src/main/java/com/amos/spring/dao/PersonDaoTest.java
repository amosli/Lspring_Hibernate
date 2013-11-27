package com.amos.spring.dao;

import com.amos.spring.impl.PersonDaoImplJdbcTemplateBest;
import com.amos.spring.model.Person;

/** 
* @ClassName: PersonDaoTest 
* @Description: 把关于数据库操作的类封装起来进行调用
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 28, 2013 1:59:04 AM  
*/
public class PersonDaoTest {
	private static IpersonDao dao;

	public static void main(String args[]) {
		dao = new PersonDaoImplJdbcTemplateBest();
		Person person = new Person();
		person.setName("运哥");
		person.setAge(29);
		dao.save(person);
	}
}
