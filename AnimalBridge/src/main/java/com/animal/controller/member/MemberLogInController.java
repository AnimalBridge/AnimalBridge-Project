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
		MemberVO memberLogIn = service.memberLogIn(nickName, password);
		
		if(memberLogIn == null) {
			req.setAttribute("error", "Nick Name 또는 비밀번호가 틀렸습니다.");
			
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("memberLogInNickName", memberLogIn.getNickName());
			session.setAttribute("memberLogInCenterIdx", memberLogIn.getCenterIdx());
			
			System.out.println(memberLogIn.getNickName());
			System.out.println(memberLogIn.getCenterIdx());
		}
		
		AppUtil.forward(req, resp, path);
	}
}
