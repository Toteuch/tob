package com.toteuch.tob.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.toteuch.tob.data.ConfigXYDao;
import com.toteuch.tob.data.interfaces.IConfigXYDao;
import com.toteuch.tob.entity.ConfigXY;
import com.toteuch.tob.entity.TOBUser;
import com.toteuch.tob.service.interfaces.IConfigXYService;

public class ConfigXYService implements IConfigXYService {

	private IConfigXYDao configXYDao;
	
	public void save(Map<String, ConfigXY> configXYMap) {
		System.out.println("[INFO] Saving ConfigXY...");
		Set<String> set = configXYMap.keySet();
		for(String key : set) {
			ConfigXY configIHM = configXYMap.get(key);
			ConfigXY configPers = configXYDao.getConfigXYByLabelAndUser(configIHM.getLabel(), configIHM.getTobUser());
			configPers.setX(configIHM.getX());
			configPers.setY(configIHM.getY());
			configXYDao.save(configPers);
		}
	}
	
	public List<ConfigXY> getAllByUser(TOBUser currentUser) {
		System.out.println("[INFO] Getting all ConfigXY for user : " + currentUser.getLogin());
		return configXYDao.getConfigXYByUser(currentUser);
	}
	
	private ConfigXYService() {
		configXYDao = ConfigXYDao.getInstance();
	}
	
	private static class ConfigXYServiceHolder {
		private static ConfigXYService instance = new ConfigXYService();
	}
	
	public static ConfigXYService getInstance() throws Exception {
		return ConfigXYServiceHolder.instance;
	}
}
