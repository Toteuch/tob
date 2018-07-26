package com.toteuch.tob.service;

import com.toteuch.tob.BotXY;
import com.toteuch.tob.hardware.BotBase;
import com.toteuch.tob.hardware.GameSystem;
import com.toteuch.tob.hardware.IBotBase;


public class BotNavigationService implements IBotNavigationService {

	private IBotNavigationInterceptor navigationInterceptor;
	private IBotBase botBase;
	private boolean alreadyReco;
	
	private BotNavigationService() throws Exception {
		navigationInterceptor = BotNavigationInterceptor.getInstance();
		botBase = BotBase.getInstance();
	}
	
	public boolean gotoGalaxyPage() throws Exception {
		System.out.println("[INFO] Going to galaxy page");
		alreadyReco = navigationInterceptor.reconnectIfHaveTo(this.alreadyReco);
		// botBase.clicCoord(MouseCoord.BUTTON_GALAXY);
		botBase.clicCoord(BotXY.BUTTON_GALAXY.getX(), BotXY.BUTTON_GALAXY.getY());
		System.out.println("[INFO] At galaxy page");		
		return true;
	}
	
	public boolean gotoGalaxySystem(GameSystem system) throws Exception {
		System.out.println("[INFO] Going to galaxy:ss : " + system.getGalaxy() + ":" + system.getSystem());
		if(navigationInterceptor.reconnectIfHaveTo(this.alreadyReco)) {
			this.alreadyReco = true;
			this.gotoGalaxyPage();
		}
		// Type galaxy
		botBase.fillGalaxyCoordOnGalaxyPageAndGo(system);
		
		System.out.println("[INFO] At galaxy:ss : " + system.getGalaxy() + ":" + system.getSystem());
		
		return true;
	}
	
	private static class BotNavigationServiceHolder {
		private static BotNavigationService instance;
		private static BotNavigationService getInstance() throws Exception {
			if(instance == null) {
				instance = new BotNavigationService();
			}
			return instance;
		}
	}
	
	public static BotNavigationService getInstance() throws Exception {
		return BotNavigationServiceHolder.getInstance();
	}
}
