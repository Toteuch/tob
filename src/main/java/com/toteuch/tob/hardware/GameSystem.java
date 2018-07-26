package com.toteuch.tob.hardware;

public class GameSystem {
	public int galaxy;
	public int system;
	
	public GameSystem(int galaxy, int system) {
		this.galaxy = galaxy;
		this.system = system;
	}

	public int getGalaxy() {
		return galaxy;
	}

	public int getSystem() {
		return system;
	}

	public void setGalaxy(int galaxy) {
		this.galaxy = galaxy;
	}

	public void setSystem(int system) {
		this.system = system;
	}
}
