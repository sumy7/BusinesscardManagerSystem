package com.sumy.action;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.MyUnicodeStringSource;
import com.sumy.type.Message;
import com.sumy.type.OnlineUser;

public class RegistUser extends ActionSupport {

	private String username;
	private String password;
	private String repeatpass;
	public Message mess = null;

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
		username = username.trim();
		password = password.trim();
		if (username.equals("") || password.equals("")) {
			mess = new Message(
					MyUnicodeStringSource.getValue("regist_infofaild"),
					Message.MESSAGETYPE_DANGER);
			return "infonull";
		}
		if (!password.equals(repeatpass)) {
			mess = new Message(
					MyUnicodeStringSource.getValue("regist_pwdnotequal"),
					Message.MESSAGETYPE_WARNING);
			return "notequal";
		}
		OnlineUser user = Database.findUserbyname(username);
		if (user != null) {
			mess = new Message(
					MyUnicodeStringSource.getValue("regist_nameexist"),
					Message.MESSAGETYPE_WARNING);
			return "nameexist";
		}
		Database.RegistUser(username, password, 1);
		mess = new Message(MyUnicodeStringSource.getValue("regist_success"),
				Message.MESSAGETYPE_SUCCESS);
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
		OnlineUser user = Database.findUserbyname(checkusername);
		if (user == null) {
			message = "false";
		} else {
			message = "true";
		}
		return "success";
	}
}
