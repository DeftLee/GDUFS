package com.gdufs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordManageDao {
	public boolean checkUserAndEmail(String userName,String email) {
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from gdufs.user where userName='"+userName+"' and email='"+email+"';";
		
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
	}
}
