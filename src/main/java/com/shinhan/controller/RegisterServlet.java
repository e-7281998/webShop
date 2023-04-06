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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/auth/signup.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String mname = request.getParameter("manager_name");
		//get방식은 patameter가 넘어올 때 url에 encoding되어 들어온다. 
		//post방식은 parameter가 넘어올 때 요청문서의 body에 들어온다. 한글이 깨짐
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		AdminVO vo = new AdminVO(email, mname, pass);
		AdminService service = new AdminService();
		int result = service.registerAdmin(vo);
		
		response.setContentType("text/html;charset=utf-8");
		//응답 문서 얻기
		PrintWriter out = response.getWriter();	//응답문서의 body 부분에 출력된다.
		
		if(result == 1) {
			out.print("<h1>계정 등록 성공</h1>");
			//직원조회 페이지로 이동...
		}else {
			out.print("<h1>계정 등록 실패</h1><p>잠시후 회원가입 화면으로 넘어갑니다.</p>");
			response.setHeader("refresh", "2;login.jsp");
			//response.sendRedirect("login.jsp");	//재요청
		}
	}

}
