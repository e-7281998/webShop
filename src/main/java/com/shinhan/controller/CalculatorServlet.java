package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/mvc2model/calc")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page 보여주기...주소창의 주소를 변경한다.(재요청)
		//response.sendRedirect("calc.jsp");
		//page 보여주기...주소창은 그대로 두고 위임하기.
		RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//계산하기
		int num1 = Integer.parseInt(request.getParameter("su1"));
		int num2 = Integer.parseInt(request.getParameter("su2"));
		String op =  request.getParameter("op");
		
		int result = 0;
		switch(op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default:
			break;
		}
		
		//원래는 jsp에서 get 요청이 들어오면 그 페이지는 새로고침되고, 기존의 값들이 날라감
		//ajax처럼 보이도록 만들기 : 페이지가 refresh되지 않은 것처럼 만들기 => 값이 유지되고, 결과만 받아오는 것처럼
		//원래 있던 폼의 su1에 num을 넣어주고, su2에 num을 넣어주고... 이렇게 함
		request.setAttribute("su1", num1);
		request.setAttribute("su2", num2);
		request.setAttribute("op", op);
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
		rd.forward(request, response);
		
		/*
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("결과는 : " + result);
		*/
	}

}
