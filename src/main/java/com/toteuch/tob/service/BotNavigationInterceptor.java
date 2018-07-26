package com.toteuch.tob.service;

import java.util.Calendar;

import com.toteuch.tob.hardware.BotBase;
import com.toteuch.tob.hardware.IBotBase;

public class BotNavigationInterceptor implements IBotNavigationInterceptor {
	
	private IBotBase botBase;
	
	private BotNavigationInterceptor() throws Exception {
		botBase = BotBase.getInstance();
	}
	
	public boolean reconnectIfHaveTo(boolean alreadyDone) throws Exception {
		Calendar heureMin = Calendar.getInstance();
		heureMin.set(Calendar.HOUR_OF_DAY, 3);
		heureMin.set(Calendar.MINUTE, 0);
		heureMin.set(Calendar.SECOND, 0);
		
		Calendar heureActuelle = Calendar.getInstance();
		if(!alreadyDone && heureActuelle.after(heureMin)) {
			botBase.reconnect();
			return true;
		}
		return false;
	}
	
	private static class BotNavigationInterceptorHolder {
		private static BotNavigationInterceptor instance;
		private static BotNavigationInterceptor getInstance() throws Exception {
			if(instance == null) {
				instance = new BotNavigationInterceptor();
			}
			return instance;
		}
	}
	
	public static BotNavigationInterceptor getInstance() throws Exception {
		return BotNavigationInterceptorHolder.getInstance();
	}
}
