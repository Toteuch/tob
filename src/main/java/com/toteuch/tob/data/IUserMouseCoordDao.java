package com.toteuch.tob.data;

import com.toteuch.tob.MouseCoord;
import com.toteuch.tob.entity.TOBUser;
import com.toteuch.tob.entity.UserMouseCoordConfig;

public interface IUserMouseCoordDao {
	public UserMouseCoordConfig findCoord(TOBUser tobuser, MouseCoord mouseCoord);
}
