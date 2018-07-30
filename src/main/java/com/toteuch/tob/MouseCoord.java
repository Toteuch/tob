package com.toteuch.tob;

public enum MouseCoord {
	BUTTON_GV("Bouton Vue Générale"),
	BUTTON_PLAY("Bouton Jouer"),
	BUTTON_GALAXY("Bouton Galaxie"),
	FIELD_GALAXY_GALAXY("Champ Galaxie (Galaxie)"),
	FIELD_GALAXY_SYSTEM("Champ Système (Galaxie)");
	
	private String label;
	
	private MouseCoord(String label) {
		this.label=label;
	}
	
	public String getLabel() {
		return this.label;
	}
}
