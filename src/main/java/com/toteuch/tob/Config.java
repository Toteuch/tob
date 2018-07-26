package com.toteuch.tob;

public enum Config {

	WAIT_TIME_MIN_MS_BETWEEN_LOADING("900"),
	WAIT_TIME_MAX_MS_BETWEEN_LOADING("1500"),
	WAIT_TIME_MIN_BETWEEN_SS_MONITOR("7000"),
	WAIT_TIME_MAX_BETWEEN_SS_MONITOR("8000");
	private String valeur;
	
	Config(String valeur) {
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}
}