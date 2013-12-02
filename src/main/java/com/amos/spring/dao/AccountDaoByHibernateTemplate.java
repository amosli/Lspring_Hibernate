package com.amos.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.amos.spring.model.Account;

public class AccountDaoByHibernateTemplate implements IAccountDao {
	private HibernateTemplate template;
	public void save(Account account) {
		template.save(account);
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void update(Long id, Account account) {
		account.setId(id);
		template.update(account);
	}

	public Account get(Long id) {
		return template.get(Account.class,id);
	}

	public void delete(Long id) {
		template.delete(get(id));
	}

	public Account get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Account> loadAll() {
		
		return template.find("from account");
		
	}

	public List<Account> query(final String scope, final Object[] parameters, final int begin, final int max) {
		return	template.execute(new HibernateCallback<List<Account>>() {
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
