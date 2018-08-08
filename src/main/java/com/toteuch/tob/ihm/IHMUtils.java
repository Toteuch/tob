package com.toteuch.tob.ihm;

import java.text.SimpleDateFormat;

import com.toteuch.tob.entity.TOBUser;

public class IHMUtils {
	
	private static final SimpleDateFormat hoursSDF = new SimpleDateFormat("HH:mm:ss");
	
	private static TOBUser currentUser;
	
	public static TOBUser getCurrentUser() {
		return currentUser;
	}
	
	public static void setCurrentUser(TOBUser tobUser) {
		currentUser = tobUser;
	}
	
	public static SimpleDateFormat getHoursSDF() {
		return hoursSDF;
	}
}
