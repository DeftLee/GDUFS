package com.gdufs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistrationDao {
	public String checkUserName(String userName) throws SQLException {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from `gdufs`.`user` where `userName`='"+userName+"';";
		
		try{
			stat = con.prepareStatement(sql);
			stat.execute(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
		return "go";
	}
	public String regist(String userName,String password,String teamType,String email,String depart) throws SQLException {
		Connection con = DBHelper.connect();
		PreparedStatement stat1 = null;
		PreparedStatement stat2 = null;
		String sql1 = "select * from `gdufs`.`user` where `userName`='"+userName+"';";
		String sql2 = "insert into `gdufs`.`user` values('"+userName+"','"+password+"','"+teamType+"','"+depart+"','"+email+"','notActive','2');";
		
		try{
			stat1 = con.prepareStatement(sql1);
			stat1.execute(sql1);
			ResultSet rs1 = stat1.executeQuery();
			if(!rs1.next()) {
				stat2 = con.prepareStatement(sql2);
				int i = stat2.executeUpdate();
				if(i!=0) {
					return "success";
				}
				else {
					return "error";
				}
			}
			else {
				String status = rs1.getString("status").trim();
				if(status.equals("active")) {
					return "active";
				}
				else {
					return "notActive";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} finally {
			DBHelper.closePreparedStatement(stat1);
			DBHelper.closePreparedStatement(stat2);
			DBHelper.closeConneciton(con);
		}
	}
	public boolean active (String userName) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "update gdufs.user set status='active' where userName='"+userName+"';";
		
		try {
			stat = con.prepareStatement(sql);
			int i = stat.executeUpdate();
			if(i!=0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
		return false;
	}
}
