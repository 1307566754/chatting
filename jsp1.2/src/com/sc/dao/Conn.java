package com.sc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conn {
	
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://127.0.0.1:3306/jsp?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
	private final static String username = "root";
	private final static String password = "root";
	private static Connection conn = null;
	
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB驱动加载失败...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取连接失败...");
		} 
		return null;
	}
}
