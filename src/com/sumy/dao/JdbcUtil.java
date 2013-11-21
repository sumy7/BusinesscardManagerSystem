package com.sumy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static String dbUrl = "jdbc:mysql://";
	private static String port = "3306";
	private static String host = "localhost";
	private static String username = "root";
	private static String password = "root";
	private static String databaseName = "card";

	private JdbcUtil() {
	};

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		String connName = dbUrl + host + ":" + port + "/" + databaseName
				+ "?useUnicode=true&characterEncoding=UTF-8";
		return DriverManager.getConnection(connName, username, password);
	}

	public static void free1(Statement st, Connection conn) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void free2(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
