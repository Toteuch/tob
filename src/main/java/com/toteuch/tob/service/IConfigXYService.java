package com.toteuch.tob.service;

import java.util.List;
import java.util.Map;

import com.toteuch.tob.entity.ConfigXY;
import com.toteuch.tob.entity.TOBUser;

public interface IConfigXYService {
	public void save(Map<String, ConfigXY> configXYMap);
	public List<ConfigXY> getAllByUser(TOBUser currentUser);
}
