package com.shinhan.model;

import com.shinhan.vo.AdminVO;

public class AdminService {
	AdminDAO dao = new AdminDAO();
	
	public AdminVO loginCheck(String email, String pass) {
		return dao.loginCheck(email, pass);
	}
}
