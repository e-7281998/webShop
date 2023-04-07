package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.EmpService;
import com.shinhan.vo.AdminVO;
import com.shinhan.vo.EmpVO;

/**
 * Servlet implementation class EmpListServelet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession browser = request.getSession();
		
		AdminVO user = (AdminVO) browser.getAttribute("loginUser");
		//AdminVO user = (AdminVO) request.getAttribute("loginUser");
		System.out.println("user:" + user);
		
		if(user==null) {
			response.sendRedirect("../auth/loginCheck.do");
			return;
		}
		
		 EmpService service = new EmpService();
		 List<EmpVO> emplist = service.selectAll();
		 
		 //request가 유지되는 동안 저장한다.
		 request.setAttribute("empAll", emplist);
		 
		 //위임(요청을 받고 응답은 다른 페이지가 한다.)
		 RequestDispatcher rd = request.getRequestDispatcher("empSelect.jsp");
		 rd.forward(request, response);
	}  
}
