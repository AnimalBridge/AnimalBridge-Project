package com.animal.controller.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.MemberVO;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class MemberLogInController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String path = "/view/index.jsp";
		String nickName = req.getParameter("nickName");
		String password = req.getParameter("password");
		
		Service service = Service.getInstance();
		MemberVO memberLogIn = service.memberLogIn(nickName, password);
		
		if(memberLogIn == null) {
			resp.sendRedirect("/AnimalBridge/view/memberView/memberLogInFail.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("memberLogInNickName", memberLogIn.getNickName());
			
			System.out.println(memberLogIn.getNickName());
		}
		
		AppUtil.forward(req, resp, path);
	}
}
