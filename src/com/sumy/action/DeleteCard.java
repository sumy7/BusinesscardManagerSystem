package com.sumy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class DeleteCard extends ActionSupport{
	private String cardid;
	private Card usercard;
	@Override
	public String execute() throws Exception {
		if(cardid==null || cardid.equals("")) return "iderror";
		usercard=Database.getCardbyId(Integer.parseInt(cardid));
		OnlineUser visitor = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		visitor = (OnlineUser) session.get("visitor");
		if(usercard==null) return "iderror";
		if(usercard.getOwner()!=visitor.getId()) return "usererror";
		Database.moveCardtoRecycle(Integer.parseInt(cardid));
		return "success";
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
}
