package com.shinhan.frontcontrollerpattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

public class JSTLController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		// /로 시작하면 절대경로, /가 없으면 상대경로다.
		//return "/jsptest/jstlTest3.jsp";
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		application.setAttribute("myName", "이태민");
		session.setAttribute("myName", "최민호");
		request.setAttribute("myName", "김기범");
		
		List<AdminVO> adminlist = new ArrayList<>();
		adminlist.add(new AdminVO("ltm@smtown.com", "ltm", "123"));
		adminlist.add(new AdminVO("cmh@smtown.com", "cmh", "123"));
		adminlist.add(new AdminVO("kkb@smtown.com", "kkb", "123"));
		request.setAttribute("admins", adminlist);
		
		request.setAttribute("score", 90);
		
		request.setAttribute("today", new Date());
		
		return "/jsptest/jstlTest3.jsp";	
		
	}

}
