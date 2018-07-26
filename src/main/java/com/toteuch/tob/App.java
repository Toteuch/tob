package com.toteuch.tob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toteuch.tob.data.ITOBUserDao;
import com.toteuch.tob.data.TOBUserDao;
import com.toteuch.tob.entity.TOBUser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ITOBUserDao tobUserDao = new TOBUserDao();
    	
    	TOBUser user = new TOBUser("test3", "test3");
		tobUserDao.saveNewUser(user);
    	
//        try {
//        	IBotSurveillanceService surveillanceService = BotSurveillanceService.getInstance();
//            System.out.println( "Hello World!" );
//            String playerName = "Harry Cover";
//            List<GameSystem> listSystems = new ArrayList<GameSystem>();
//            listSystems.add(new GameSystem(3, 187));
//            listSystems.add(new GameSystem(3, 261));
//            listSystems.add(new GameSystem(3, 413));
//            listSystems.add(new GameSystem(4, 32));
//            listSystems.add(new GameSystem(4, 49));
//            listSystems.add(new GameSystem(4, 69));
//            listSystems.add(new GameSystem(4, 156));
//            listSystems.add(new GameSystem(4, 333));
//        	surveillanceService.monitorSystems(listSystems, playerName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
