package com.toteuch.tob.data;

import java.util.List;

import com.toteuch.tob.entity.ConfigXY;
import com.toteuch.tob.entity.TOBUser;

public interface IConfigXYDao {
	public void save(ConfigXY configXY);
	public List<ConfigXY> getConfigXYByUser(TOBUser tobUser);
	public ConfigXY getConfigXYByLabelAndUser(String label, TOBUser tobuser);
}
