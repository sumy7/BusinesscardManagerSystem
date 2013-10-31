package com.sumy.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;

public class RegistUser extends ActionSupport {

	private String username;
	private String password;
	private String repeatpass;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatpass() {
		return repeatpass;
	}

	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}

	@Override
	public String execute() throws Exception {
		if (!password.equals(repeatpass))
			return "notequal";
		String sql = "insert into user(logname,passwd,power) values(?,?,?)";
		Connection conn = Database.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setInt(3, 1);
		ps.execute();
		return "success";
	}

}
