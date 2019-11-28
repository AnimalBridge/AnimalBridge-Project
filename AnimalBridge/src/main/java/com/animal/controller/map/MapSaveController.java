package com.animal.controller.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.MapService;
import com.animal.vo.MapVO;
import com.animal.vo.MemberVO;
import javax.servlet.http.HttpSession;


public class MapSaveController implements SubController{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		String member_nickName = (String)session.getAttribute("memberLogInNickName");

		if(member_nickName != null && member_nickName != "") {
			
			MapVO mapVO = new MapVO();

			String x = req.getParameter("x");
			String y = req.getParameter("y");
			String title = req.getParameter("title");
			String special = req.getParameter("special");
			String map_address = req.getParameter("address");

			mapVO.setMember_nickname(member_nickName);
			mapVO.setX(x);
			mapVO.setY(y);
			mapVO.setTitle(title);
			mapVO.setSpecial(special);
			mapVO.setMap_address(map_address);


			MapService mapService = MapService.getInstance();
			int result = mapService.saveAll(mapVO);

			if(result>0) {
				resp.sendRedirect("/AnimalBridge/view/mapView/Map.do");
			}else if(result <= 0){
				resp.sendRedirect("/AnimalBridge/view/mapView/MapFalse.jsp");
			}
		}else if(member_nickName == null) {
			resp.sendRedirect("/AnimalBridge/view/memberView/memberLogIn.jsp");
		}else {
			resp.sendRedirect("/AnimalBridge/view/mapView/MapFalse.jsp");
		}
	}
}
