package com.toteuch.tob.entity;

public class UserConfig {
	
	private long id;
	private User tobUser;
	private int minWaitTimeLoading;
	private int maxWaitTimeLoading;
	
	public UserConfig(User tobUser) {
		this.tobUser = tobUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getTobUser() {
		return tobUser;
	}

	public void setTobUser(User tobUser) {
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
