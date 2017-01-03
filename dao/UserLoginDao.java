package com.gdufs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gdufs.entity.User;

public class UserLoginDao {
	public User findUser(String userName,String password,String userType) throws SQLException {
		User user = null;
		Connection con = DBHelper.connect();
		PreparedStatement stat = null;
		String sql = "select * from `gdufs`.`user` where `userName` = '" + userName + "' and `password` = '" + password + "' and `type` = '" + userType + "';";

		try {
			stat = con.prepareStatement(sql);
			stat.execute(sql);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				String status = rs.getString("status").trim();
				return new User(userName,password,userType,status);
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closePreparedStatement(stat);
			DBHelper.closeConneciton(con);
		}
		return user;
	}
}
