package com.toteuch.tob.data;

import com.toteuch.tob.entity.TOBUser;

public interface ITOBUserDao {
	public Long saveNewUser(TOBUser tobUser);
	public TOBUser getTOBUserByLogin(String login);
}
