package org.bigjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DButil {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/bigjava?useSSL=false";
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";
	private static final String DRIVER = null;
	
	public static Connection getConnection() {
		Connection conn = null;
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static DataSource setupDateSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		
		//datasourse configs
		ds.setInitialSize(100);
		ds.setMaxIdle(20);
		ds.setMaxWaitMillis(1000*10);
		return ds;
		
	}
	
	public static void shutdownDataSource(DataSource ds) {
		try {
			BasicDataSource bds = (BasicDataSource) ds;
			if(bds!=null) bds.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
