package com.toteuch.tob.service;

import com.toteuch.tob.entity.TOBUser;

public interface ITOBUserService {
	public TOBUser findByLogin(String login);
	public void createTOBUser(String login, String passwd);
}
