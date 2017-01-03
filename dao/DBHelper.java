package com.gdufs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	public static Connection connect() {
		String dbDriver="com.mysql.jdbc.Driver";
        String dbUrl="jdbc:mysql://localhost:3306/gdufs?useUnicode=true&characterEncoding=utf8";
        String dbUser="root";
        String dbPassword="111111";
        try {           
            Class.forName(dbDriver).newInstance();
            Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("数据库连接成功");
            return con;
        } catch (Exception ex) {
        	System.out.println("数据库连接失败"+ex.toString());
            return null;
        }
   }
   public static void closeResult(ResultSet rs) {
       try {
           rs.close();
       } catch (SQLException e) {
       }
   }
   public static void closePreparedStatement(PreparedStatement ps) {
       try {
           ps.close();
       } catch (SQLException e) {
       }
   }
   public static void closeConneciton(Connection con) {
       try {
           con.close();
       } catch (SQLException e) {
       }
   }
}
