package com.toteuch.tob.data;

import com.toteuch.tob.MouseCoord;
import com.toteuch.tob.entity.User;
import com.toteuch.tob.entity.UserMouseCoordConfig;

public interface IUserMouseCoordDao {
	public UserMouseCoordConfig findCoord(User tobuser, MouseCoord mouseCoord);
}
