package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/getcookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
 		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.write("<h1>쿠키 읽기 연습</h1>");
		 
		//브라우저에 저장된 쿠키가 요청과 함께 혼다. 쿠키 읽기
		//쿠키는 무조건 배열로 읽어야 함 
		Cookie[] cs = request.getCookies();
		for(Cookie c:cs) {	//cs는 쿠키타입임
			//c.getName() : 쿠키 이름 얻기
			if(c.getName().equals("userid") || c.getName().equals("userpass"))
				out.write(c.getName() + " ===> " + c.getValue() + "<br>");
		}
		
	} 
}
