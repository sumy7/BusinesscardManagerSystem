package com.sumy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.LoginUser;

public class CheckUser extends ActionSupport {
	private LoginUser user = new LoginUser();

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		if (user == null)
			return ("error");
		if (Database.checkuser(user.getUsername(), user.getPassword()))
			return "success";
		return "failer";
	}

}
