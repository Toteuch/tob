package com.toteuch.tob;

public enum BotXY {
	
	BUTTON_GV(-1400,270),
	BUTTON_PLAY(-600,270),
	BUTTON_GALAXY(-1400,520),
	FIELD_G_GALAXY(-1220,250),
	FIELD_G_SS(-1070,250);
	
	private int x, y;
	
	BotXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
