package com.animal.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.animal.controller.SubController;
import com.animal.controller.happyBoard.HappyBoardController;
import com.animal.controller.happyBoard.HappyBoardViewController;
import com.animal.controller.happyBoard.HappyBoardWriterController;
import com.animal.controller.map.MapSaveController;
import com.animal.controller.map.MapShowController;
import com.animal.controller.member.MemberJoinController;
import com.animal.controller.member.MemberLeaveController;
import com.animal.controller.member.MemberLogInController;
import com.animal.controller.member.MemberLogOutController;


public class ContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Map<String, SubController> controllers = new HashMap<String, SubController>();		
		
	// Member table
		controllers.put("/view/memberView/memberJoin.do", new MemberJoinController());
		controllers.put("/view/memberView/memberLogIn.do", new MemberLogInController());
		controllers.put("/view/memberView/memberLogOut.do", new MemberLogOutController());
		controllers.put("/view/memberView/memberLeave.do", new MemberLeaveController());
		
	// Map table
		controllers.put("/view/mapView/Map.do", new MapShowController());
		controllers.put("/view/mapView/SaveMap.do", new MapSaveController());
		
	// HappyBoard table
		controllers.put("/view/happyBoardView/happyBoard.do", new HappyBoardController());
		controllers.put("/view/happyBoardView/happyBoardWriter.do", new HappyBoardWriterController());
		controllers.put("/view/happyBoardView/happyBoardView.do", new HappyBoardViewController());
		
		event.getServletContext().setAttribute("controllers", controllers);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) { }
}
