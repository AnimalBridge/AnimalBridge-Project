package com.animal.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;
import com.animal.vo.MemberVO;

public class MemberJoinController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/memberView/memberJoinResult.jsp";
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String nickName = req.getParameter("nickName");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVO memberVO = new MemberVO(email, 
										 name,
										 nickName,
										 password,
										 phone,
										 addr);
		
		Service service = Service.getInstance();
		int result = service.memberJoin(memberVO);
		
		if(result > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("memberLogInNickName", nickName);
			
		} else {
			req.setAttribute("error", "회원가입이 실패하였습니다");
		}
		
		AppUtil.forward(req, resp, path);
	}
}
