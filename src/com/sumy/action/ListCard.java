package com.sumy.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class ListCard extends ActionSupport {
	private ArrayList<Card> cardlist;
	private int numperpage = 0;
	private int pagenum = 0;

	public ArrayList<Card> getCardlist() {
		return cardlist;
	}

	public void setCardlist(ArrayList<Card> cardlist) {
		this.cardlist = cardlist;
	}

	@Override
	public String execute() throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();

		cardlist = Database.getCardlist(visitor.getId(), 0);
		return "success";
	}

	public String list() throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();

		cardlist = Database.getCardlist(visitor.getId(), 0);
		return "success";
	}

	public String recycle() throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();
		
		cardlist = Database.getCardlist(visitor.getId(), 1);
		return "recycle";
	}
}
