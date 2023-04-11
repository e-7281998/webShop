package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
//@WebFilter("/*")	//css,js,jsp,servlet,image
@WebFilter("*.do")	//~.do
public class LoginCheckFilter extends HttpFilter implements Filter {
        
    public LoginCheckFilter() {
        super();
     }
  
	public void destroy() {
		// TODO Auto-generated method stub
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 		// place your code here

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//if의 조건들은 로그인 되었는지 체크하면 안됨. 로그아웃 상태여도 가능해야 함.
		if(req.getServletPath().equals("/auth/loginCheck.do") ||
			req.getServletPath().equals("/auth/signup.do") ||
			req.getServletPath().equals("/auth/emailDupCheck.do")) {
				
		}else {

			HttpSession browser = req.getSession();
			AdminVO user = (AdminVO) browser.getAttribute("loginUser"); 
			
			if(user==null) {
				res.sendRedirect(req.getContextPath() + "/auth/loginCheck.do");
				return;
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
	} 
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
