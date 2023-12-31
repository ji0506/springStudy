package com.spring.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	
	public static Connection getConnection() {
		
		try {

			Class.forName("org.h2.Driver");			
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", "");

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs,PreparedStatement stmt,Connection conn) {
		
		if(rs != null) {

			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(conn != null) {

			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
