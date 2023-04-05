package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/loginCheck.do")	//url 매핑 주소를 정함
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass"); 
		AdminService service = new AdminService();
		AdminVO admin = service.loginCheck(email, pass);
		System.out.println(admin==null ? "로그인 실패" : admin);
		
		//응답 문서 만들기
		//<meta charset="UTF-8">와 같음
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out = response.getWriter();
		
		if(admin == null) {
			//3초 후에 refresh해라. login.jsp로. 이 내용을 헤더에 알려줌. 현재 /auth 이므로 경로는 맞춰서 사용하면 됨
			response.setHeader("refresh", "3;login.jsp");
			out.print("<h1>Login Fail</h1>");
			return;
		}
		
		out.print("<h1>Login Infromation</h1>");
		out.printf("<h1>이메일은 %s</h1>", email);
		out.printf("<h1>이메일은 %s</h1>", admin.getManager_name());
	} 

}
