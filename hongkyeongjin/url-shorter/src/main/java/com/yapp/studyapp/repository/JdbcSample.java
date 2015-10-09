package com.yapp.studyapp.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcSample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		//연결정보
		//connection string
		String connStr="jdbc:mysql://mango.smu.ac.kr:3306/url-shorter";
		Connection conn=(Connection) DriverManager.getConnection(connStr,"yapp","diqldiql");
		Statement stmt=(Statement) conn.createStatement();
		stmt.executeUpdate("INSERT INTO URL_TBL (url) VALUES ('hkj')");
		ResultSet rs=stmt.executeQuery("SELECT * FROM URL_TBL");
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		rs.close();
		stmt.close();
	    conn.close();
	}
}
