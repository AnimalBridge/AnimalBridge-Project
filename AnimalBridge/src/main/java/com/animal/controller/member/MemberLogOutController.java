package com.animal.controller.member;

import javax.servlet.http.HttpServletResponse;

import com.animal.controller.SubController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class MemberLogOutController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		String url = context.getContextPath() + "/view/memberView/index.jsp";
		
		req.getSession().invalidate();  //session 값 모두 지우기
		
		resp.sendRedirect(url);
	}
}
