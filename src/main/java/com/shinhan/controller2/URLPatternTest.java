package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLPatternTest
 */
//@WebServlet("/url/test/*") //폴터 형태
//@WebServlet("*.go")	//확장자 url pattern인 경우 폴더와 같이 사용안됨
@WebServlet("/url/test/*")
public class URLPatternTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///webShop
		System.out.println(" getContextPath :" + request.getContextPath());
		///webShop/url/test
		System.out.println(" getRequestURI :" + request.getRequestURI());
		//http://localhost:9090/webShop/url/test
		System.out.println(" getRequestURL :" + request.getRequestURL());
		//GET
		System.out.println(" getMethod :" + request.getMethod());
		//서버에 접속한 클라이언트 IP 어드레스
		System.out.println(" getRemoteAddr :" + request.getRemoteAddr());	//클라이언트 주소
		//getContextPath 제외한 나머지 url => /url/test
		System.out.println(" getServletPath :" + request.getServletPath());
		//요청한 URL 이름 뒷부분의 url : /url/test/hel 일 경우 => /hel
		System.out.println(" getPathInfo :" + request.getPathInfo());
		System.out.println(" getQueryString :" + request.getQueryString());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
