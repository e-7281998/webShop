package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shinhan.util.OracleUtil;
import com.shinhan.vo.AdminVO;

public class AdminDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public int dupCheck(String email ) {
 		String sql = "select count(*) from admins where email =? ";
		int count = 0;
 		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, email);
			rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return count;
	}
	
	public AdminVO loginCheck(String email, String pass) {
		AdminVO admin = null;
		String sql = "select * from admins where email =? and pass =?";
		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			rs = st.executeQuery();
			while (rs.next()) {
				admin = new AdminVO();
				admin.setEmail(email);
				admin.setPass(pass);
				admin.setManager_name(rs.getString("manager_name"));
				admin.setPic(rs.getString("pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return admin;
	}
	
	public int registerAdmin(AdminVO admin) {
		int result = 0;
			String sql = " insert into admins(email,pass,manager_name, pic) values(?,?,?,?)";
			conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, admin.getEmail());
			st.setString(2, admin.getPass());
			st.setString(3, admin.getManager_name());
			st.setString(4, admin.getPic());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
			return result;
		}
}
