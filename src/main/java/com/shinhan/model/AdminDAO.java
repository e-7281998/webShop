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
	
	public AdminVO loginCheck(String email, String pass) {
		AdminVO admin = null;
		String sql = "select manager_name from admins where email =? and pass =?";
		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			rs = st.executeQuery();
			while (rs.next()) {
				admin = new AdminVO(email, rs.getString(1), pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return admin;
	}
}
