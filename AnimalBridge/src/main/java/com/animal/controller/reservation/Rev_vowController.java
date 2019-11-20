package com.animal.controller.reservation;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animal.controller.AppUtil;
import com.animal.controller.SubController;
import com.animal.service.Service;

public class Rev_vowController implements SubController {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		String path = "/view/reservationView/rev_calendar.jsp";
		
	
		
		 
		AppUtil.forward(req, resp, path);
	}

}
