package com.sumy.action;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.LoginUser;
import com.sumy.type.OnlineUser;

public class CheckUser extends ActionSupport {
	private LoginUser user = new LoginUser();

	@JSON(serialize = false)
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
		OnlineUser visitor = Database.checkuser(user.getUsername(),
				user.getPassword());
		if (visitor != null) {
			SessionOperationAdapter.sessionSetUser(visitor);
			return "success";
		}
		return "failer";
	}

	public String logout() throws Exception {
		SessionOperationAdapter.sessionDelUser();
		return "success";
	}

	private String islogin;
	private String visitorname;

	@JSON
	public String getIslogin() {
		return islogin;
	}

	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}

	@JSON
	public String getVisitorname() {
		return visitorname;
	}

	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}

	public String toGetSessionName() throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();
		if (visitor == null) {
			islogin = "false";
			visitorname = "сн©м";
		} else {
			islogin = "true";
			visitorname = visitor.getUsername();
		}
		return "success";
	}
}
