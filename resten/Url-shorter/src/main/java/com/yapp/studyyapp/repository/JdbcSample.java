package com.yapp.studyyapp.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class JdbcSample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//클래스 정보를 JVM에 등록(정적 초기화 블럭 실행)
		
		//연결정보
		//connection String
		//userName, password
		String connStr = "jdbc:mysql://mango.smu.ac.kr:3306/url-shorter";
		Connection  conn =DriverManager.getConnection(connStr,"yapp","diqldiql");
		
		Statement stmt = conn.createStatement();
				
	    stmt.executeUpdate("INSERT INTO URL_TBL (url) VALUES ('BH')");
	    ResultSet rs = stmt.executeQuery("SELECT * FROM URL_TBL ");
	    while(rs.next()){
	    	System.out.println(rs.getInt(1)+" "+rs.getString(2));
	    }
	    rs.close();
	    stmt.close();
	    conn.close();
	    
	}
}
