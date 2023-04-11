package com.shinhan.frontcontrollerpattern;

import java.io.UnsupportedEncodingException;
import java.util.Map;

//모든 Controller의 규격서
public interface CommonControllerInterface {
	//String에는 페이지를 돌려줄 것, 소통은 Map형태로... 아마도
	public String execute(Map<String, Object> data) throws Exception;
}
