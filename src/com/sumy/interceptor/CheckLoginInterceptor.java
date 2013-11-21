package com.sumy.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.Message;
import com.sumy.type.OnlineUser;

public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();
		if (visitor == null) {
			return "novisitor";
		}
		String result = invocation.invoke();
		return result;
	}

}
