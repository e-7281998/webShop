package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

public class AdminPicAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		//모든 회원 조회하기
		AdminService service = new AdminService();
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		List<AdminVO> adminlist = service.adminSelectAll();
		request.setAttribute("adminList", adminlist);
		
		return "adminView.jsp";
	}

}
