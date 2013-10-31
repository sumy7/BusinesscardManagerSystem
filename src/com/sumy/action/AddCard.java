package com.sumy.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class AddCard extends ActionSupport {
	private Card usercard = new Card();

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

		Connection conn = Database.getConnection();
		String sql;

		sql = "insert into cardinfo(name,position,tel,email,address,photo,owner,isdel) values(?,?,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, usercard.getName());
		ps.setString(2, usercard.getPositon());
		ps.setString(3, usercard.getTel());
		ps.setString(4, usercard.getEmail());
		ps.setString(5, usercard.getAddress());
		ps.setString(6, "");
		ps.setInt(7, visitor.getId());
		ps.setInt(8, 0);
		ps.execute();

		return "success";
	}

}
