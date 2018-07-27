package com.toteuch.tob.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.toteuch.tob.entity.TOBUser;

public class TOBUserDao implements ITOBUserDao {
	
	private Session session;
	
	private TOBUserDao() {
		session = HibernateUtil.getSession();
	}
	
	public Long saveNewUser(TOBUser tobUser) {
		return (Long) session.save(tobUser);
		
	}

	public TOBUser getTOBUserByLogin(String login) {
		Criteria criteria = session.createCriteria(TOBUser.class);
		criteria.add(Restrictions.eqOrIsNull("login", login));
		return (TOBUser) criteria.uniqueResult();
	}
	
	private static class TOBUserDaoHolder {
		private final static TOBUserDao instance = new TOBUserDao();
	}
	
	public static TOBUserDao getInstance() {
		return TOBUserDaoHolder.instance;
	}
}
