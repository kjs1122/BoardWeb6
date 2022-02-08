package com.springbook.biz;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
	
	public static void main (String args[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("연결 완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
