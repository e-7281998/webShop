package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shinhan.util.OracleUtil;
import com.shinhan.vo.AdminVO;
import com.shinhan.vo.DeptVO;

public class AdminDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;

	public List<AdminVO> adminSelectAll() {
		List<AdminVO> adminList = new ArrayList<>();
		
		String sql = "select * from ( select * from admins order by manager_name desc ) where rownum <=3";
		conn = OracleUtil.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AdminVO admin = new AdminVO();
				admin.setEmail(rs.getString("email"));
				admin.setManager_name(rs.getString("manager_name"));
				admin.setPic(rs.getString("pic"));
				adminList.add(admin);
 			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		
		return adminList;
	}
	
	public int dupCheck(String email) {
		String sql = "select count(*) from admins where email =? ";
		int count = 0;
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}

	public AdminVO loginCheck(String email, String pass) {
		AdminVO admin = null;
		String sql = "select * from admins where email =? and pass =?";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
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
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		return admin;
	}

	public int registerAdmin(AdminVO admin) {
		int result = 0;
		String sql = " insert into admins(email,pass,manager_name, pic) values(?,?,?,?)";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getEmail());
			pst.setString(2, admin.getPass());
			pst.setString(3, admin.getManager_name());
			pst.setString(4, admin.getPic());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		return result;
	}
}
