package com.sumy.dao;

import java.sql.Connection;
import java.util.List;

public abstract class IDatabase {
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public abstract boolean setDS(String SQL);

	public abstract List getDS(String SQL);

}
