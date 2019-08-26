package org.bigjava.util;

import java.sql.*;

public class SimpleDBUtil {
	
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bigjava?useUnicode=true&characterEncoding=utf-8";
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";
	
	public static Connection getConnection() {
		System.out.println("打开数据库连接");
		Connection conn = null;
		try {	
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		System.out.println("关闭数据库连接");
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


}
