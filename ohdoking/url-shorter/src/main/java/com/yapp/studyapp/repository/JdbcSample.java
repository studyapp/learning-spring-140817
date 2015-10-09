package com.yapp.studyapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public class JdbcSample {
	public static void main(String[] args) {

		// SPI

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결 정보
			//Connection String
			//username, pw
			String connStr = "jdbc:mysql://mango.smu.ac.kr/url-shorter";
			Connection conn = DriverManager.getConnection(connStr,"yapp","diqldiql");
			
			Statement stmt = conn.createStatement();
			
//			String insertSql = "Insert into URL_TBL (url) values ('ohdoking')";
//			int id = stmt.executeUpdate(insertSql);
//			
//			System.out.println(id);
			
			
			String selectAllSql = "select * from URL_TBL order by id ASC";
			ResultSet rs= stmt.executeQuery(selectAllSql);
			
			while(rs.next()){
				System.out.println(rs.getInt(1) +"/" +rs.getString(2));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Class.forName("com.yapp.studyapp.repository.StaticInitBlock");
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
