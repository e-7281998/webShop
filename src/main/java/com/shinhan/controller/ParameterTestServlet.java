package com.shinhan.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterTestServlet
 */
@WebServlet("/param")
public class ParameterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter 이름 읽고, 값 가져오기
		//방법1
		String userid = request.getParameter("userid");
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");	//배열읽기
		
		 System.out.println("userid" + userid); System.out.println("salary" + salary);
		 System.out.println("gender" + gender); System.out.println("hobby" +
		 Arrays.toString(hobby));
		
		//방법2
		//열거가 가능한 형태의 문자열
		//파라미터 이름을 하나씩 가져와 출력
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {	//.hasMoreElements:paramNames에 있는지 물어봄
			String param = paramNames.nextElement();
			
			if(param.equals("hobby")) {	//hoby는 배열이므로 다른 방법으로 읽어야 함
				//getParameterValues는 배열을 읽을 때 사용함
				String[] value = request.getParameterValues(param);
				System.out.println(param + " ==== " + Arrays.toString(value));
			}else {
				String value = request.getParameter(param);
				System.out.println(param + " ==== " + value);
			}
			
		}
		 
	}  

}
