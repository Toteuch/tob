package com.toteuch.tob.entity;

public class UserConfig {
	
	private long id;
	private TOBUser tobUser;
	private int minWaitTimeLoading;
	private int maxWaitTimeLoading;
	
	public UserConfig(TOBUser tobUser) {
		this.tobUser = tobUser;
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

	public int getMinWaitTimeLoading() {
		return minWaitTimeLoading;
	}

	public void setMinWaitTimeLoading(int minWaitTimeLoading) {
		this.minWaitTimeLoading = minWaitTimeLoading;
	}

	public int getMaxWaitTimeLoading() {
		return maxWaitTimeLoading;
	}

	public void setMaxWaitTimeLoading(int maxWaitTimeLoading) {
		this.maxWaitTimeLoading = maxWaitTimeLoading;
	}
	
	
}
