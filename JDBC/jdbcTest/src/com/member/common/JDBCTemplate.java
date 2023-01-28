package com.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//DAO들이 공통으로 사용하는 기능을 가지고 있는 클래스
	//Connection생성, transaction처리 메소드, 각 객체를 닫아주는 메소드를 가지고 있음
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("oricale.jdbc.driver.OracleDreiver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@loaclhos:1521:xe","BS","BS");
//			conn=DriverManager.getConnection("jdbc:oracle:thin:@gd1class.iptime:8877:xe","student","student");
			conn.setAutoCommit(false);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
			
	}
	//트랜젝션처리메소드
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
