package com.sumy.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class SearchCard extends ActionSupport {
	private ArrayList<Card> cardlist;
	private String keyword = null;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

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

		if (visitor == null)
			return "novisitor";
		if (keyword == null) {
			cardlist = new ArrayList<Card>();
			return "nokeyword";
		}
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("keyword" + keyword);
		cardlist = Database.searchCardlist(keyword, keyword, keyword, keyword,
				keyword, visitor.getId(), 0);
		return "success";
	}
}
