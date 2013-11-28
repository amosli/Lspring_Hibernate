package com.amos.spring.model;

/** 
* @ClassName: Person 
* @Description: TODO
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 27, 2013 12:35:54 AM  
*/
public class Person {
	private Long id;
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
