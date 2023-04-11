package com.shinhan.frontcontrollerpattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	//doGet + doPost 인것이 service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getMethod() + " 요청 ");	//get인지 post인지 알아보기
		//System.out.println(request.getRequestURI() + " uri "); 	///webShop/auth/loginCheck.do
		//System.out.println(request.getServletPath() + " getServletPath "); ///auth/loginCheck.do
		
		String path = request.getServletPath();	//auth/loginCheck.do 
		CommonControllerInterface controller = null;
		Map<String, Object> data = new HashMap<>();
		data.put("method", request.getMethod());
		data.put("request", request);
		
		switch (path) { 
		case "/auth/loginCheck.do":
			controller = new LoginController();
			 break;
		case "/auth/signup.do":
			controller = new SignUpController();
			break;
		case "/emp/emplist.do":
			controller = new EmpListController();
			break;
		case "/emp/empDetail.do":
			controller = new EmpDetailController();
			break;
		case "/emp/empinsert.do":
			controller = new EmpInsertController();
			break;
		case "/emp/empDelete.do":
			controller = new EmpDeleteController();
			break;
		case "/auth/emailDupCheck.do":
			controller = new EmailDupCheckController();
			break;
		default:
			break;
		}
		
		//page에 리턴할 때..
		//auth/login.jsp 혹은 redirect:auth/loginCheck.do와 같이 할 것임
		String page = null;
		try {
			page = controller.execute(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(page.indexOf("redirect:") >= 0) {
			//redirect:auth/loginCheck.do가 들어오면 9번째부터 끝까지 잘라서 보내라(redirect:는 잘라야 하므로)
			response.sendRedirect(page.substring(9));
		}else if(page.indexOf("responseBody") >= 0){
			response.getWriter().append(page.charAt(page.length()-1));
			//response.getWriter().append(page.substring(13));
		}else {	//redirect가 아니면 포워드 시키기
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
		
	}

}
