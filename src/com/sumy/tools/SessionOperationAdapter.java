package com.sumy.tools;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.sumy.type.OnlineUser;

public class SessionOperationAdapter {
	public static OnlineUser sessionGetUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionId = request.getSession().getId();
		System.out.println("--------------------------------------sessionID:" + sessionId);
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
}
