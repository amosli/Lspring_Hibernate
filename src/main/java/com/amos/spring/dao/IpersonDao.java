package com.amos.spring.dao;

import java.util.List;

import com.amos.spring.model.Person;

/** 
* @ClassName: IpersonDao 
* @Description: TODO
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 27, 2013 12:35:48 AM  
*/
public interface IpersonDao {
	void save(Person p);

	void update(Long id, Person p);

	void delete(Long id);

	List<Person> loadAll();

}
