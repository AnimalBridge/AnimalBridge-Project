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

public class MemberLeaveController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/memberView/memberLeaveResult.jsp";
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberLogIn");
		String nickName = memberVO.getNickName();
		
		Service service = Service.getInstance();
		int result = service.memberLeave(nickName);
		
		if(result > 0) {
			req.setAttribute("result", "회원탈퇴가 정상처리 되었습니다");
			session.invalidate(); //session 값 모두 지우기
			
		} else {
			req.setAttribute("error", "회원탈퇴가 처리되지 못했습니다");
		}
		
		AppUtil.forward(req, resp, path);
	}	
}
