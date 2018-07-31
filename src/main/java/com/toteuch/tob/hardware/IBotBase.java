package com.toteuch.tob.hardware;

import com.toteuch.tob.entity.GameSystem;

public interface IBotBase {
	//public void clicCoord(MouseCoord tobMouseCoord) throws Exception;
	public void clicCoord(int x, int y) throws Exception;
	public void fillGalaxyCoordOnGalaxyPageAndGo(GameSystem system) throws Exception;
	public void reconnect() throws Exception;
	public void wait(int borneInf, int borneSup);
	public void moveMouse(int x, int y) throws Exception;
}
