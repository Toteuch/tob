package com.toteuch.tob.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.toteuch.tob.data.interfaces.ITOBUserDao;
import com.toteuch.tob.entity.TOBUser;

public class TOBUserDao implements ITOBUserDao {
	
	private TOBUserDao() {
	}
	
	public Long saveNewUser(TOBUser tobUser) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Long id = (Long) session.save(tobUser);
		tx.commit();
		session.close();
		return id;
		
	}

	public TOBUser getTOBUserByLogin(String login) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = session.createCriteria(TOBUser.class);
		criteria.add(Restrictions.eqOrIsNull("login", login));
		TOBUser retVal = (TOBUser) criteria.uniqueResult();
		session.close();
		return retVal;
	}
	
	private static class TOBUserDaoHolder {
		private final static TOBUserDao instance = new TOBUserDao();
	}
	
	public static TOBUserDao getInstance() {
		return TOBUserDaoHolder.instance;
	}
}
