package com.toteuch.tob;

import java.util.ArrayList;
import java.util.List;

import com.toteuch.tob.hardware.GameSystem;
import com.toteuch.tob.service.IBotSurveillanceService;
import com.toteuch.tob.service.BotSurveillanceService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
        	IBotSurveillanceService surveillanceService = BotSurveillanceService.getInstance();
            System.out.println( "Hello World!" );
            String playerName = "Harry Cover";
            List<GameSystem> listSystems = new ArrayList<GameSystem>();
            listSystems.add(new GameSystem(3, 187));
            listSystems.add(new GameSystem(3, 261));
            listSystems.add(new GameSystem(3, 413));
            listSystems.add(new GameSystem(4, 32));
            listSystems.add(new GameSystem(4, 49));
            listSystems.add(new GameSystem(4, 69));
            listSystems.add(new GameSystem(4, 156));
            listSystems.add(new GameSystem(4, 333));
        	surveillanceService.monitorSystems(listSystems, playerName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
