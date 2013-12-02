package com.amos.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.amos.spring.model.Account;
 
/** 
* @ClassName: AccountDaoByHibernateDaoSupport 
* @Description: 使用Spring中的HibernateDaoSupport来实例化IAccountDao
* @author: amosli
* @email:amosli@infomorrow.com
* @date Dec 3, 2013 1:14:12 AM  
*/
public class AccountDaoByHibernateDaoSupport extends HibernateDaoSupport implements IAccountDao {
	public void save(Account account) {
		getHibernateTemplate().save(account);
	}

	public void update(Long id, Account account) {
		account.setId(id);
		getHibernateTemplate().update(account);
	}

	public Account get(Long id) {
		return getHibernateTemplate().get(Account.class,id);
	}

	public void delete(Long id) {
		getHibernateTemplate().delete(get(id));
	}

	public Account get(String name) {
		return getHibernateTemplate().get(Account.class, name);
	}

	@SuppressWarnings("unchecked")
	public List<Account> loadAll() {
		return getHibernateTemplate().find("from account");
	}

	public List<Account> query(final String scope, final Object[] parameters, final int begin, final int max) {
		return	getHibernateTemplate().execute(new HibernateCallback<List<Account>>() {
			@SuppressWarnings("unchecked")
			public List<Account> doInHibernate(Session session) throws HibernateException, SQLException {
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
			}
		});
	}

}
