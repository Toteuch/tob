package com.toteuch.tob.service;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import com.toteuch.tob.Config;
import com.toteuch.tob.hardware.BotBase;
import com.toteuch.tob.hardware.GameSystem;
import com.toteuch.tob.hardware.IBotBase;

public class BotSurveillanceService implements IBotSurveillanceService {
	
	private IBotNavigationService navigationService;
	
	private IBotBase botBase;
	
	private BotSurveillanceService() throws Exception {
		navigationService = BotNavigationService.getInstance();
		botBase = BotBase.getInstance();
	}
	
	public void monitorSystems(List<GameSystem> listSystem, String playerName) throws Exception {
		navigationService.gotoGalaxyPage();
		String sBorneInf = Config.WAIT_TIME_MIN_BETWEEN_SS_MONITOR.getValeur();
		String sBorneSup = Config.WAIT_TIME_MAX_BETWEEN_SS_MONITOR.getValeur();
		int borneInf = Integer.parseInt(sBorneInf);
		int borneSup = Integer.parseInt(sBorneSup);
		while(true) {
			for(GameSystem system : listSystem) {
				navigationService.gotoGalaxySystem(system);
				saveScreenshot(system, playerName);
				botBase.wait(borneInf, borneSup);
			}
		}
	}
	
	private static boolean saveScreenshot(GameSystem system, String playerName) throws HeadlessException, AWTException, IOException {
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(-1920, -17, 1920, 1080));
		SimpleDateFormat imageNameDateFormat = new SimpleDateFormat("dd_MM_yyyy-hh_mm_ss");
		String imageName = playerName + "-" + system.getGalaxy() + "_" + system.getSystem() + "-" + imageNameDateFormat.format(new Date());
		ImageIO.write(image, "png", new File("E:\\BotSurveillance\\"+imageName+".png"));
		return true;
	}
	
	private static class BotSurveillanceServiceHolder {
		private static BotSurveillanceService instance;
		private static BotSurveillanceService getInstance() throws Exception {
			if(instance == null) {
				instance = new BotSurveillanceService();
			}
			return instance;
		}
	}
	
	public static BotSurveillanceService getInstance() throws Exception {
		return BotSurveillanceServiceHolder.getInstance();
	}
}
