package com.sumy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.LoginUser;
import com.sumy.type.OnlineUser;

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
			return "error";
		OnlineUser visitor=Database.checkuser(user.getUsername(), user.getPassword());
		if (visitor!=null)
		{
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("visitor", visitor);
			return "success";
		}
		return "failer";
	}

}
