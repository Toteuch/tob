package com.toteuch.tob.service;

import com.toteuch.tob.hardware.GameSystem;

public interface IBotNavigationService {
	public boolean gotoGalaxyPage() throws Exception;
	public boolean gotoGalaxySystem(GameSystem system) throws Exception;
	public void testCoords(int x, int y) throws Exception;
}
