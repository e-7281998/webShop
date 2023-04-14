package com.shinhan.model;

import java.util.List;

import com.shinhan.vo.AdminVO;

public class AdminService {
	AdminDAO dao = new AdminDAO();
	public List<AdminVO> adminSelectAll() {
		return dao.adminSelectAll();
	}
	public int registerAdmin(AdminVO admin) {
		return dao.registerAdmin(admin);
	}
	public AdminVO loginCheck(String email, String pass) {
		return dao.loginCheck(email, pass);
	}
	public int dupCheck(String email ) {
		return dao.dupCheck(email);
	}
}
