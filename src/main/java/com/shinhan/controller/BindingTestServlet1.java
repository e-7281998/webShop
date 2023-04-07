package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingTestServlet1
 */
@WebServlet("/bind1")
public class BindingTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application 영역 : ServletContext에 저장 : WAS가 살아있는 동안 유효
		//session 영역 : Browser가 살아있는 동안 유효
		//request 영역 : request가 살아있는 동안 유효
		
		ServletContext application = request.getServletContext();
		HttpSession browser = request.getSession();
		
		application.setAttribute("mydata1", "application에 저장함"); 
		browser.setAttribute("mydata2", "browser에 저장함(browser가 살아있는 동안.."); 
		request.setAttribute("mydata3", "request에 저장함");
		
		application.setAttribute("myname", "태민");
		browser.setAttribute("myname", "기범");
		request.setAttribute("myname", "민호");
		
		//자신의 페이지 보여주기 싫음..
		RequestDispatcher rd;
		//실제 값을 저장한 것은 (위에서 저장함..) bind1인데 보여주는 것은 bind2임.
		rd = request.getRequestDispatcher("bind2");
		rd.forward(request, response);
		
		//자신의 페이지 보여줌
//		response.setContentType("text/html;charset=utf-8;");
// 		response.getWriter().append("Served at: ")
// 				.append(request.getContextPath())
// 				.append((String) application.getAttribute("mydata1")+"<br>")
// 				.append((String) browser.getAttribute("mydata2")+"<br>")
// 				.append((String) request.getAttribute("mydata3"));	//얻으면 무조건 obj임... 그러므로 String으로 형변환이 필요하다.
	} 
}
