package com.toteuch.tob.service.interfaces;

public interface IBotNavigationInterceptor {
	public boolean reconnectIfHaveTo(boolean alreadyDone) throws Exception;
}
