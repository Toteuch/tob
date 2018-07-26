package com.toteuch.tob.service;

public interface IBotNavigationInterceptor {
	public boolean reconnectIfHaveTo(boolean alreadyDone) throws Exception;
}
