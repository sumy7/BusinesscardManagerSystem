package com.sumy.action;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.MyUnicodeStringSource;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.LoginUser;
import com.sumy.type.Message;
import com.sumy.type.OnlineUser;

public class CheckUser extends ActionSupport {
	public Message mess = null;
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
		if (user == null || user.getUsername().equals("")
				|| user.getPassword().equals("")) {
			mess = new Message(MyUnicodeStringSource.getValue("login_faild"),
					Message.MESSAGETYPE_DANGER);
			return "error";
		}
		OnlineUser visitor = Database.checkuser(user.getUsername(),
				user.getPassword());
		if (visitor != null) {
			SessionOperationAdapter.sessionSetUser(visitor);
			mess = new Message(MyUnicodeStringSource.getValue("login_success"),
					Message.MESSAGETYPE_SUCCESS);
			return "success";
		}
		mess = new Message(MyUnicodeStringSource.getValue("login_pwderror"),
				Message.MESSAGETYPE_WARNING);
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
			visitorname = "visitor";
		} else {
			islogin = "true";
			visitorname = visitor.getUsername();
		}
		return "success";
	}

	public String redirect() throws Exception {
		mess = new Message(MyUnicodeStringSource.getValue("login_notlogin"),
				Message.MESSAGETYPE_INFO);
		return "success";
	}
}
