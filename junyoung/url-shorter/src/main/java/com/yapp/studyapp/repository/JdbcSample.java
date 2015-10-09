package com.yapp.studyapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		
		// 연결 정보
		// Connection String
		// username, password
		String connStr = "jdbc:mysql://mango.smu.ac.kr:3306/url-shorter";
		
		Connection conn = DriverManager.getConnection(
				connStr, "yapp", "diqldiql");
		
		Statement stmt = conn.createStatement();
		
		
		stmt.executeUpdate("INSERT INTO URL_TBL (url) VALUES ('junyoung')");
		
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM URL_TBL ORDER BY id");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		
	}
}
