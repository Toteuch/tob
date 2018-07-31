package com.toteuch.tob.hardware;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import com.toteuch.tob.BotXY;
import com.toteuch.tob.Config;

public class BotBase implements IBotBase {
	Robot robot;

	private BotBase() throws AWTException {
		robot = new Robot();
	}
	
	public void clicCoord(int x, int y) throws Exception {
		moveMouse(x, y);
		leftClic();
		waitLoading();
	}

	public void fillGalaxyCoordOnGalaxyPageAndGo(GameSystem system) throws Exception {
		//moveMouse(MouseCoord.FIELD_GALAXY_GALAXY);
		moveMouse(BotXY.FIELD_G_GALAXY.getX(), BotXY.FIELD_G_GALAXY.getY());
		leftClic();
		typeValue(system.getGalaxy());

		// Type SS
		//moveMouse(MouseCoord.FIELD_GALAXY_SYSTEM);
		moveMouse(BotXY.FIELD_G_SS.getX(), BotXY.FIELD_G_SS.getY());
		leftClic();
		typeValue(system.getSystem());

		// Enter
		enter();
		waitLoading();
	}
	
	public void moveMouse(int x, int y) {
		robot.mouseMove(x, y);
	}

	private void leftClic() {
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	private void waitLoading() throws Exception {
		// Entre 900ms et 1000ms
		String sBorneInf = Config.WAIT_TIME_MIN_MS_BETWEEN_LOADING.getValeur();
		String sBorneSup = Config.WAIT_TIME_MAX_MS_BETWEEN_LOADING.getValeur();
		try {
			int borneSup = Integer.parseInt(sBorneSup);
			int borneInf = Integer.parseInt(sBorneInf);
			wait(borneInf, borneSup);
		} catch (NumberFormatException e) {
			throw new Exception("[FATAL] Can't convert wait loading time", e);
		}
	}

	public void wait(int borneInf, int borneSup) {
		int ecart = (borneSup - borneInf);
		double random = Math.random();
		double delay = random * ecart + borneInf;
		long lDelay = Math.round(delay);
		int iDelay = (int) lDelay;
		System.out.println("[INFO] Waiting " + iDelay + "ms...");
		this.robot.delay(iDelay);
	}

	private void typeValue(Object o) throws Exception {
		if (o instanceof Integer) {
			Integer value = (Integer) o;
			String sGalaxy = String.valueOf(value);
			char[] digitsGalaxy = sGalaxy.toCharArray();
			for (char c : digitsGalaxy) {
				int key = getKeyFromDigit(c);
				robot.keyPress(key);
				robot.keyRelease(key);
			}
		} else {
			throw new Exception("Non pris en charge actuellement");
		}
	}

	private void enter() {
		int key = KeyEvent.VK_ENTER;
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	private int getKeyFromDigit(char digit) throws Exception {
		int key = 0;
		switch (digit) {
		case '0':
			key = KeyEvent.VK_NUMPAD0;
			break;
		case '1':
			key = KeyEvent.VK_NUMPAD1;
			break;
		case '2':
			key = KeyEvent.VK_NUMPAD2;
			break;
		case '3':
			key = KeyEvent.VK_NUMPAD3;
			break;
		case '4':
			key = KeyEvent.VK_NUMPAD4;
			break;
		case '5':
			key = KeyEvent.VK_NUMPAD5;
			break;
		case '6':
			key = KeyEvent.VK_NUMPAD6;
			break;
		case '7':
			key = KeyEvent.VK_NUMPAD7;
			break;
		case '8':
			key = KeyEvent.VK_NUMPAD8;
			break;
		case '9':
			key = KeyEvent.VK_NUMPAD9;
			break;
		default:
			throw new Exception("digit incorrect : " + digit);
		}
		return key;
	}

	public void reconnect() throws Exception {
		System.out.println("[INFO] Reconnecting...");
		// Clic General View
		clicCoord(BotXY.BUTTON_GV.getX(), BotXY.BUTTON_GV.getY());

		// Clic Play
		clicCoord(BotXY.BUTTON_PLAY.getX(), BotXY.BUTTON_PLAY.getY());
		System.out.println("[INFO] Reconnected");
	}

	private static class BotBaseHolder {
		private static BotBase instance;

		private static BotBase getInstance() throws Exception {
			if (instance == null) {
				instance = new BotBase();
			}
			return instance;
		}

	}

	public static BotBase getInstance() throws Exception {
		return BotBaseHolder.getInstance();
	}
}
