package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/loginCheck.do")	//url 매핑 주소를 정함
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//웹 어플리케이션에 하나있다. 공유 영역임. ServletContext
	ServletContext app;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		app = getServletContext();
		Object obj = app.getAttribute("visitor");
//		int count = 1;
//		if(obj!=null) {
//			count = (Integer)obj;
//			count++;
//		}
//		app.setAttribute("visitor", count);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass"); 
		AdminService service = new AdminService();
		AdminVO admin = service.loginCheck(email, pass);
		System.out.println(admin==null ? "로그인 실패" : admin);
		
		List<AdminVO> userList = null;
		Object obj = app.getAttribute("userList");
		if(admin != null) {
			if(obj== null) {
				userList = new ArrayList<>();

			}else {
				userList = (List<AdminVO>)obj;
			}
			userList.add(admin);
			app.setAttribute("userList", userList);
			
			for(AdminVO vo:userList) {
				System.out.println("로그인 한 사람 : "+vo);
			}
		}
		
 		
		
		//응답 문서 만들기 : header + ResponseBody에 문자열 출력하기
		//<meta charset="UTF-8">와 같음
		response.setContentType("text/html;charset=utf-8");	
		//일단 응답 문서를 만들음 => response.getWriter()
		PrintWriter out = response.getWriter();

//		System.out.println("api찍어봄"+request.getRemoteAddr());
		printAccessUser(request.getRemoteAddr());
		 
		if(admin == null) {
			//응답문서의 header부분을 작성해서 내려간다. 3초 후 재요청한다는 의미다. 
			//3초 후에 refresh해라. login.jsp로. 이 내용을 헤더에 알려줌. 현재 /auth 이므로 경로는 맞춰서 사용하면 됨
			response.setHeader("refresh", "3;loginCheck.do");	//html중 <head>에 들어감. 세팅함	//sendredirect와 같음.
			out.print("<h1 style='color:red;'>Login Fail</h1>");
			return;
		} 

		//로그인한 사람의 정보를 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", admin);
		request.setAttribute("loginUser", admin);
		
		//응답문서에 주소창을 바꾼다.	//location.href="";와 같음	//둘 다 get방식임
		//http://localhost:9090/ 까지만 들어옴
		 String path = request.getContextPath();
		 String encodeName = URLEncoder.encode( admin.getManager_name(), "UTF-8" );
		response.sendRedirect(path+"/emp/emplist.do?myname="+encodeName);
		
		
		//재요청
//		out.print("<script>"
//				+ "alert('로그인 성공');"
//				+ "location.href='"
//				+ path
//				+ "/emp/emplist.do';"
//				+ "</script>");
	}

	private void printAccessUser(String accApi) {
		String api[] = accApi.split("[.:]");
 		String accessUser ="";
		switch(api[3]) {
			case "0":
				accessUser = "내";
				break;
			case "106":
				accessUser = "경윤";
				break;
			default:
				accessUser = "등록안된 사람";
				break;
		}
		System.out.println("************"+accessUser+"(이)가 접속시도함~~");		
	} 

}
