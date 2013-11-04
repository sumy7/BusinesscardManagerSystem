package com.sumy.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.OnlineUser;

public class RegistUser extends ActionSupport {

	private String username;
	private String password;
	private String repeatpass;

	@JSON(serialize = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JSON(serialize = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JSON(serialize = false)
	public String getRepeatpass() {
		return repeatpass;
	}

	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}

	@Override
	public String execute() throws Exception {
		if(username.equals("") || password.equals(""))
			return "infonull";
		if (!password.equals(repeatpass))
			return "notequal";
		OnlineUser user = Database.findUserbyname(username);
		if(user!=null)
			return "nameexist";
		Database.RegistUser(username, password, 1);
		return "success";
	}

	private String checkusername;
	private String message;

	@JSON(serialize = false)
	public String getCheckusername() {
		return checkusername;
	}

	public void setCheckusername(String checkusername) {
		this.checkusername = checkusername;
	}

	@JSON
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toCheckUsername() throws Exception {
		System.out.println("tocheckusername" + checkusername);
		OnlineUser user = Database.findUserbyname(checkusername);
		if (user == null) {
			message = "false";
		} else {
			message = "true";
		}
		return "success";
	}
}
