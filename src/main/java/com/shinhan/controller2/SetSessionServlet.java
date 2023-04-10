package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		HttpSession session = request.getSession(); //최초 접속인 경우 Session값 없음. 자동 생성한다. (true)	//지금은 set하는 연습이므로 최초임..!
		System.out.println(session.getId());
		System.out.println(session.getMaxInactiveInterval());	//default : 30분
		System.out.println(session.isNew()); //최초로 생성된 세션인지 확인 : true //이미 생성되어 있었다면 : false
		
		session.setAttribute("key1", userid);
		session.setAttribute("key2", 100);
		session.setAttribute("key3", new AdminVO("fx@smtown.com","fx","1234"));
		 
		
		response.setContentType("text/html;charset=utf-8");	//<meta charset="utf-8"/>
		PrintWriter out = response.getWriter();
		out.write("<h1>세션 저장 연습</h1>");
	}
  

}
