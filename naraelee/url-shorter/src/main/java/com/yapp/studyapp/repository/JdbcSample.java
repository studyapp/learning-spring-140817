package com.yapp.studyapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSample {

	public static void main(String[] args) throws Exception {
		// StaticInitBlock.print();
		//
		// new StaticInitBlock();

		// Class.forName("com.yapp.studyapp.repository.StaticInitBlock");

		Class.forName("com.mysql.jdbc.Driver");

		// 연결정보
		// Connection String
		// username, pwd
		String conStr = "jdbc:mysql://mango.smu.ac.kr:3306/url-shorter";
		Connection conn = DriverManager.getConnection(conStr, "yapp", "diqldiql");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO URL_TBL (url) values ('naraelee_')");
		
		ResultSet rs = stmt.executeQuery("select * from URL_TBL");
		while (rs.next()){
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		

	}
}
