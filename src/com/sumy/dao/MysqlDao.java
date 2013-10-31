package com.sumy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sumy.tools.CovertList;

public class MysqlDao extends IDatabase {
	private static MysqlDao instance = null;

	public static MysqlDao getInstance() {
		if (instance == null)
			instance = new MysqlDao();
		return instance;
	}

	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	private Statement stmt;
	ResultSet rs;

	private MysqlDao() {
		try {
			String url = "jdbc:mysql://localhost/card?useUnicode=true&characterEncoding=UTF-8";
			String user = "root";
			String pwd = "root";

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url, user, pwd);

			stmt = conn.createStatement();

		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
		}
	}

	@Override
	public boolean setDS(String SQL) {
		try {
			stmt.executeUpdate(SQL);
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
			return false;
		}
		return true;
	}

	@Override
	public List getDS(String SQL) {
		List rslist;
		try {
			rs = stmt.executeQuery(SQL);
			rslist = CovertList.convertList(rs);
		} catch (Exception ex) {
			System.out.println("Error : " + ex.toString());
			return null;
		}
		return rslist;
	}

	public static void main(String arg[]) {
		IDatabase database = new MysqlDao();
		List list = database.getDS("select * from user");
		for (int i = 0; i < list.size(); i++) {
			Map rowmap = (HashMap) list.get(i);
			System.out.println(rowmap.toString());
		}
	}
}
