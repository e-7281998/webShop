package com.shinhan.frontcontrollerpattern;

import java.util.Map;

public class LayoutTestController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
//		frontcontroller에서 "/layout.do"와 같이 요청하면 다음과 같이 사용해야 함.
//		String page = "site-result/layoutTest.jsp";
		String page = "layoutTest.jsp";
 		return page;
	}

}
