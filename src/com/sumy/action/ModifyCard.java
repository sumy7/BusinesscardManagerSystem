package com.sumy.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class ModifyCard extends ActionSupport {
	private String cardid;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	private Card usercard;

	public Card getUsercard() {
		return usercard;
	}

	public void setUsercard(Card usercard) {
		this.usercard = usercard;
	}

	@Override
	public String execute() throws Exception {
		OnlineUser visitor = null;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		visitor = (OnlineUser) session.get("visitor");
		if (visitor == null)
			return "novisitor";
		usercard = Database.getCardbyId(Integer.parseInt(cardid));
		if (usercard == null)
			return "cardiderror";
		if (usercard.getOwner() != visitor.getId())
			return "usererror";
		return "success";
	}
}