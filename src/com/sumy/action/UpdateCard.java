package com.sumy.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.type.Card;

public class UpdateCard extends ActionSupport {
	Card usercard = new Card();

	public Card getUsercard() {
		return usercard;
	}

	public void setUsercard(Card usercard) {
		this.usercard = usercard;
	}

	@Override
	public String execute() throws Exception {
		Connection conn = Database.getConnection();
		String sql;
		sql = "update cardinfo set name=?,position=?,tel=?,email=?,address=?,photo=?,owner=?,isdel=? where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, usercard.getName());
		ps.setString(2, usercard.getPositon());
		ps.setString(3, usercard.getTel());
		ps.setString(4, usercard.getEmail());
		ps.setString(5, usercard.getAddress());
		ps.setString(6, "");
		ps.setInt(7, usercard.getOwner());
		ps.setInt(8, 0);
		ps.setInt(9, usercard.getId());
		ps.execute();
		return "success";
	}

}
