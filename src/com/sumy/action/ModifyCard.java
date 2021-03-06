package com.sumy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.MyUnicodeStringSource;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.Card;
import com.sumy.type.Message;
import com.sumy.type.OnlineUser;

public class ModifyCard extends ActionSupport {
	private String cardid;
	private Card usercard;
	public Message mess = null;

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public Card getUsercard() {
		return usercard;
	}

	public void setUsercard(Card usercard) {
		this.usercard = usercard;
	}

	@Override
	public String execute() throws Exception {
		if (cardid == null || cardid.equals("")) {
			mess = new Message(MyUnicodeStringSource.getValue("card_idfaild"),
					Message.MESSAGETYPE_DANGER);
			return "iderror";
		}
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();
		usercard = Database.getCardbyId(Integer.parseInt(cardid));
		if (usercard.getIsdel() == 1) {
			mess = new Message(
					MyUnicodeStringSource.getValue("card_editrecyclecard"),
					Message.MESSAGETYPE_WARNING);
			return "modifydelcard";
		}
		if (usercard == null) {
			mess = new Message(MyUnicodeStringSource.getValue("card_iderror"),
					Message.MESSAGETYPE_DANGER);
			return "cardiderror";
		}
		if (usercard.getOwner() != visitor.getId()) {
			mess = new Message(
					MyUnicodeStringSource.getValue("card_powerfaild"),
					Message.MESSAGETYPE_DANGER);
			return "usererror";
		}
		return "success";
	}
}
