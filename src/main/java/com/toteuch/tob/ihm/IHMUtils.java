package com.toteuch.tob.ihm;

import com.toteuch.tob.entity.TOBUser;

public class IHMUtils {
	
	private static TOBUser currentUser;
	
	public static TOBUser getCurrentUser() {
		return currentUser;
	}
	
	public static void setCurrentUser(TOBUser tobUser) {
		currentUser = tobUser;
	}
}
