package com.toteuch.tob.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.toteuch.tob.data.interfaces.IGameSystemDao;
import com.toteuch.tob.entity.GameSystem;

public class GameSystemDao implements IGameSystemDao {

	
	public GameSystem saveGameSystem(GameSystem gameSystem) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.flush();
		session.clear();
		GameSystem persisted = (GameSystem) session.save(gameSystem);
		tx.commit();
		session.close();
		return persisted;
	}
	
	private GameSystemDao() {
	}
	
	private static class GameSystemDaoHolder {
		private final static GameSystemDao instance = new GameSystemDao();
	}
	
	public static GameSystemDao getInstance() {
		return GameSystemDaoHolder.instance;
	}


}
