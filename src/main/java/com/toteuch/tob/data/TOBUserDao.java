package com.toteuch.tob.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.toteuch.tob.entity.TOBUser;

public class TOBUserDao implements ITOBUserDao {
	
	private Session session;
	
	public TOBUserDao() {
		SessionFactory sessionFactory= new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public Long saveNewUser(TOBUser tobUser) {
		return (Long) session.save(tobUser);
		
	}

	public TOBUser getTOBUserByLogin(String login) {
		Criteria criteria = session.createCriteria(TOBUser.class);
		criteria.add(Restrictions.eqOrIsNull("login", login));
		return (TOBUser) criteria.uniqueResult();
	}

}
