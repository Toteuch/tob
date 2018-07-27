package com.toteuch.tob.service;

import com.toteuch.tob.entity.TOBUser;

public class TOBUserService implements ITOBUserService {

	public TOBUser findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createTOBUser(String login, String passwd) {
		// TODO Auto-generated method stub
		
	}

	private static class TOBUserServiceHolder {
		private static TOBUserService instance = new TOBUserService();
	}
	
	public static TOBUserService getInstance() throws Exception {
		return TOBUserServiceHolder.instance;
	}
}
