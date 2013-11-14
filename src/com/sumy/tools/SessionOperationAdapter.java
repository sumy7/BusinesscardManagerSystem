package com.sumy.tools;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sumy.type.OnlineUser;

public class SessionOperationAdapter {
	public static OnlineUser sessionGetUser() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		OnlineUser visitor = (OnlineUser) session.get("visitor");
		return visitor;
	}

	public static void sessionSetUser(OnlineUser visitor) {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("visitor", visitor);
	}

	public static void sessionDelUser() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("visitor");
	}
}
