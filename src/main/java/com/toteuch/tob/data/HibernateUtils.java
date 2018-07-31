package com.toteuch.tob.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	
	private static Configuration configuration = new Configuration().configure();
	private static SessionFactory sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
