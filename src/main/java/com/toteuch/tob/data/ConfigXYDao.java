package com.toteuch.tob.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.toteuch.tob.data.interfaces.IConfigXYDao;
import com.toteuch.tob.entity.ConfigXY;
import com.toteuch.tob.entity.TOBUser;

public class ConfigXYDao implements IConfigXYDao {

	public void save(ConfigXY configXY) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ConfigXY.class);
		criteria.add(Restrictions.eqOrIsNull("tobuser", configXY.getTobUser()));
		criteria.add(Restrictions.eqOrIsNull("label", configXY.getLabel()));
		ConfigXY existant = (ConfigXY) criteria.uniqueResult();
		configXY.setId(existant.getId());
		session.flush();
		session.clear();
		session.saveOrUpdate(configXY);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<ConfigXY> getConfigXYByUser(TOBUser tobUser) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = session.createCriteria(ConfigXY.class);
		criteria.add(Restrictions.eqOrIsNull("tobuser", tobUser));
		List<ConfigXY> retVal = (List<ConfigXY>) criteria.list();
		session.close();
		return retVal;
	}
	
	public ConfigXY getConfigXYByLabelAndUser(String label, TOBUser tobuser) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = session.createCriteria(ConfigXY.class);
		criteria.add(Restrictions.eqOrIsNull("tobuser", tobuser));
		criteria.add(Restrictions.eqOrIsNull("label", label));
		ConfigXY retVal = (ConfigXY) criteria.uniqueResult();
		session.close();
		return retVal;
	}
		
	private ConfigXYDao() {
	}
	
	private static class ConfigXYDaoHolder {
		private final static ConfigXYDao instance = new ConfigXYDao();
	}
	
	public static ConfigXYDao getInstance() {
		return ConfigXYDaoHolder.instance;
	}
}
