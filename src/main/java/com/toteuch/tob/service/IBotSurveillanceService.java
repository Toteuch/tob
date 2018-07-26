package com.toteuch.tob.service;

import java.util.List;

import com.toteuch.tob.hardware.GameSystem;

public interface IBotSurveillanceService {
	public void monitorSystems(List<GameSystem> listSystem, String playerName) throws Exception;
}
