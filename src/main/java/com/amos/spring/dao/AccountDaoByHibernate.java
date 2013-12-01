package com.amos.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amos.spring.model.Account;

public class AccountDaoByHibernate implements IAccountDao {

	public void save(Account account) {
		Session session = HibernateUtil.getSession();
		;
		Transaction transaction = session.beginTransaction();
		try {
			session.save(account);
			// 提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void update(Long id, Account account) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(account);
			// 提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public Account get(Long id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Account) session.get(Account.class, id);
		} finally {
			session.close();
		}
	}

	public Account get(String name) {
		Session session = HibernateUtil.getSession();
		try {
			return (Account) session.get(Account.class, name);
		} finally {
			session.close();
		}
	}

	public List<Account> loadAll() {
		Session session = HibernateUtil.getSession();
		try {
			return (List<Account>) session.createQuery("from Account").list();
		} finally {
			session.close();
		}
	}

	public List<Account> query(String scope, Object[] parameters, int begin, int max) {

		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("from Account where "+scope);
			//设置参数
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
				query.setParameter(i,parameters[i]);	
				}
			}
			if(begin>=0&&max>0){
				query.setFirstResult(begin);
				query.setMaxResults(max);
			}
			return query.list();
		} finally {
			session.close();
		}
	
	
	
	}

	public void delete(Long id) {
		Session session = HibernateUtil.getSession();
		;
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(get(id));
			// 提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

}
