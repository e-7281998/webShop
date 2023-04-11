package com.shinhan.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	int total_user;

	public SessionListener() {
		System.out.println("SessinListener  생성");
	}

	public void sessionCreated(HttpSessionEvent se) {
		total_user++;
		System.out.println(total_user + "번째 Browser가 이 서버에 접속되었음");

	}

	//세션이 지워졌는지 감시하는 역할?
	public void sessionDestroyed(HttpSessionEvent se)  { 
    	
		total_user--;
    	System.out.println(total_user + "Browser가 이 서버에 접속 해제 되었음");
    }

}
