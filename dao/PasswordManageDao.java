package com.gdufs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordManageDao {
	public String checkUserAndEmail(String userName,String email) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from gdufs.user where userName='"+userName+"' and email='"+email+"';";
		
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return "right";
			}
			else {
				return "wrong";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
	}
	
	public String checkName(String userName) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from gdufs.user where userName='"+userName+"';";
		
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				String status = rs.getString("status").trim();
				if(status.equals("active")) {
					return "active";
				}
				else {
					return "notActive";
				}
			}
			else {
				return "notExist";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
	}
	
	public String getPass(String userName) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from gdufs.user where userName='"+userName+"';";
		
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				String pass = rs.getString("password");
				return pass;
			}
			else {
				return "error";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
	}
	
	public String checkUserAndPass(String userName,String password) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from gdufs.user where userName='"+userName+"' and password='"+password+"';";
		
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return "right";
			}
			else {
				return "wrong";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
	}
}
