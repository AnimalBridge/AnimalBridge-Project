package com.animal.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.animal.controller.SubController;
import com.animal.controller.member.MemberJoinController;
import com.animal.controller.member.MemberLeaveController;
import com.animal.controller.member.MemberLogInController;
import com.animal.controller.member.MemberLogOutController;
import com.animal.controller.reservation.Rev_vowController;

public class ContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Map<String, SubController> controllers = new HashMap<String, SubController>();		
		
		controllers.put("/view/memberView/memberJoin.do", new MemberJoinController());
		controllers.put("/view/memberView/memberLogIn.do", new MemberLogInController());
		controllers.put("/view/memberView/memberLogOut.do", new MemberLogOutController());
		controllers.put("/view/memberView/memberLeave.do", new MemberLeaveController());
		
		
		
		
		/* 2019.11.19 박보금 추가 */
		controllers.put("/view/reservationView/rev_vow.do", new Rev_vowController());
		
		
		
		event.getServletContext().setAttribute("controllers", controllers);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) { }
}
