package com.shinhan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.vo.EmpVO;

/**
 * Servlet implementation class ServletContextTest1
 */
@WebServlet("/get")
public class ServletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext => application에 저장하기
		ServletContext app = request.getServletContext();
		int score = (Integer)app.getAttribute("score" );
		String name = (String) app.getAttribute("studetname" );
  		EmpVO emp = (EmpVO)app.getAttribute("empInfo" );
  		
  		System.out.println(score);
  		System.out.println(name);
  		System.out.println(emp);
  		
  		//경로를 알고 싶으면 getRealPath
  		String readPath = app.getRealPath(".");
  		System.out.println(readPath);
  		
  		//applicatin  파라메터 읽기: getInitParameter
  		String id = app.getInitParameter("DB_userid");
  		String pass = app.getInitParameter("DB_userpass");
  		System.out.println(id + "--------" + pass);
  		 
  		//webapp가 default임
  		InputStream is = app.getResourceAsStream("/WEB-INF/resource/dbinfo.txt");
  		BufferedReader br = new BufferedReader(new InputStreamReader(is));
  		String s;
  		
  		while((s = br.readLine()) != null) {
  			System.out.println(s);
  		}
  		br.close();
  		is.close();
	} 
}
