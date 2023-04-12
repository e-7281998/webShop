package com.shinhan.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//DTO, VO, JavaBeans : data를 저장해서 전송하기위해 
public class AdminVO {
	private String email;
	private String manager_name;
	private String pass;
	public AdminVO() {
		System.out.println("AdminVO---default 생성자");
	}
	public AdminVO(String email, String manager_name, String pass) {
		super();
		this.email = email;
		this.manager_name = manager_name;
		this.pass = pass;
	}
	public void setEmail(String email) {
		System.out.println("setEmail...." + email);

		this.email = email;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		System.out.println("getEmail...." + email);
		return email;
	}
	public String getManager_name() {
		return manager_name;
	}
	public String getPass() {
		return pass;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminVO [email=").append(email).append(", manager_name=").append(manager_name).append(", pass=")
				.append(pass).append("]");
		return builder.toString();
	}
	
	
}
