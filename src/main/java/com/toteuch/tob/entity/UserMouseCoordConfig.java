package com.toteuch.tob.entity;

public class UserMouseCoordConfig {
	private long id;
	private TOBUser tobUser;
	private String name;
	private int x;
	private int y;
	
	public UserMouseCoordConfig(TOBUser tobUser, String name, int x, int y) {
		this.tobUser = tobUser;
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TOBUser getTobUser() {
		return tobUser;
	}

	public void setTobUser(TOBUser tobUser) {
		this.tobUser = tobUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
