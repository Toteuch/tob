package com.toteuch.tob.service.interfaces;

import com.toteuch.tob.entity.TOBUser;

public interface ITOBUserService {
	public TOBUser findByLogin(String login);
	public void createTOBUser(String login, String passwd) throws Exception;
	public TOBUser authenticate(String login, String passwd);
}
