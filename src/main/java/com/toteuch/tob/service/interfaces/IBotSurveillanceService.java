package com.toteuch.tob.service.interfaces;

import java.util.List;

import com.toteuch.tob.entity.GameSystem;

public interface IBotSurveillanceService {
	public void monitorSystems(List<GameSystem> listSystem, String playerName) throws Exception;
}
