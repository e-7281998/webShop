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

/**
 * Servlet Filter implementation class TimeCheckFilter
 */
//@WebFilter("/*")	//다 지나감
//위의 어노테이션 막고, web.xml에 등록함
public class TimeCheckFilter extends HttpFilter implements Filter {
     
    public TimeCheckFilter() { 
    	System.out.println("TimeCheckFilter 생성자");
    } 
	public void destroy() {
    	System.out.println("TimeCheckFilter 초기화");
	} 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 		// place your code here
		//요청 필터
		long startTime = System.nanoTime();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long endTime = System.nanoTime();
		String uri = ((HttpServletRequest)request).getRequestURI(); 
		System.out.println(uri + "처리하는데 걸린 시간 : " + (endTime-startTime) + "ns");

	}
 
	public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("TimeCheckFilter init");
	}

}
