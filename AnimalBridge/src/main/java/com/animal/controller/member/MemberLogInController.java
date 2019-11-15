package com.animal.controller.member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.MemberVO;

import javax.servlet.http.HttpServletRequest;

public class MemberLogInController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String path = "/view/memberView/memberLogInResult.jsp";
		String nickName = req.getParameter("nickName");
		String password = req.getParameter("password");
		
		Service service = Service.getInstance();
		String memberLogIn = service.memberLogIn(nickName, password);
		
		if(memberLogIn == null || memberLogIn.isEmpty()) {
			req.setAttribute("error", "Nick Name 또는 비밀번호가 틀렸습니다.");
			
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("memberLogIn", memberLogIn);
		}
		
		AppUtil.forward(req, resp, path);
	}
}
