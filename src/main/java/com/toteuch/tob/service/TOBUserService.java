package com.toteuch.tob.service;

import org.apache.commons.lang3.StringUtils;

import com.toteuch.tob.data.ITOBUserDao;
import com.toteuch.tob.data.TOBUserDao;
import com.toteuch.tob.entity.TOBUser;

public class TOBUserService implements ITOBUserService {

	private ITOBUserDao userDao;

	private TOBUserService() {
		this.userDao = TOBUserDao.getInstance();
	}
	
	public TOBUser findByLogin(String login) {
		System.out.println("[INFO] Searching for TOBUser...");
		TOBUser search = userDao.getTOBUserByLogin(login);
		if(null == search) {
			System.out.println("[INFO] TOBUser not found.");
			return null;
		}
		System.out.println("[INFO] TOBUser found");
		return search;
	}

	public void createTOBUser(String login, String passwd) throws Exception {
		System.out.println("[INFO] Creating user " + login + "...");
		// Login unique
		TOBUser search = findByLogin(login);
		if(search != null) {
			throw new Exception("Login must be unique");
		}
		Long id = userDao.saveNewUser(new TOBUser(login, passwd));
		System.out.println("[DEBUG] User created, id : " + id);
		
	}

	public TOBUser authenticate(String login, String passwd) {
		System.out.println("[INFO] Authenticating...");
		TOBUser user = userDao.getTOBUserByLogin(login);
		if(null == user) {
			System.out.println("[INFO] TOBUser not found");
		} else {
			if(StringUtils.equals(user.getPasswd(), passwd)) {
				System.out.println("[INFO] User authenticated");
				return user;
			} else {
				System.out.println("[INFO] Incorrect password");
			}
		}
		return null;
	}
	
	private static class TOBUserServiceHolder {
		private static TOBUserService instance = new TOBUserService();
	}
	
	public static TOBUserService getInstance() throws Exception {
		return TOBUserServiceHolder.instance;
	}
}
