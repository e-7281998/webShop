package com.shinhan.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTestServlet
 */
@WebServlet("/requestTest/*")
public class RequestTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------------- 요청 정보 얻기 -------------------");
		System.out.println("getContextPat :" + request.getContextPath());
		System.out.println("getMethod :" + request.getMethod());
		System.out.println("getRequestURI :" + request.getRequestURI());
		System.out.println("getLocalPort :" + request.getLocalPort());
		System.out.println("getLocalAddr :" + request.getLocalAddr());
		System.out.println("getRemoteAddr :" + request.getRemoteAddr());
		System.out.println("getServletPath :" + request.getServletPath());
		System.out.println("getPathInfo :" + request.getPathInfo());	// 요청주소 : /requestTest/*에서 *에 들어오는 정보
		
		//Enumeration :한정적인 값들이 나열되어 있는 형태
		//User-Agent : 요청한 Browser의 정보 
		Enumeration<String> hs = request.getHeaderNames();
		while(hs.hasMoreElements()) {
			String name = hs.nextElement();
			System.out.println("headerName :" + name);
			System.out.println(request.getHeader(name));
			System.out.println("---------------------------");
		}
		
 		response.getWriter().append("EunJeong...Served at: ").append(request.getContextPath());
	} 

}
