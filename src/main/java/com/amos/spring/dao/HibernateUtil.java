package com.amos.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

public class HibernateUtil {
	public static SessionFactory factory;
	static {
		 factory = new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession(){
		return factory.openSession();
	}
	public static SessionFactory getFactory(){
		return factory;
	}
}
