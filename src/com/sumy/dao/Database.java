package com.sumy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sumy.tools.CovertList;
import com.sumy.type.Card;
import com.sumy.type.OnlineUser;

public class Database {
	private static IDatabase database = MysqlDao.getInstance();

	public static boolean checkuser(String username, String password)
			throws Exception {
		String sql = "select * from user where logname like ?;";
		Connection conn = database.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List rslist = CovertList.convertList(rs);
		for (int i = 0; i < rslist.size(); i++) {
			Map rowmap = (HashMap) rslist.get(i);
			if (rowmap.get("logname").equals(username)
					&& rowmap.get("passwd").equals(password)) {
				OnlineUser visitor = new OnlineUser();
				visitor.setId((Integer) rowmap.get("id"));
				visitor.setUsername((String) rowmap.get("logname"));
				visitor.setPower((Integer) rowmap.get("power"));
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
				session.put("visitor", visitor);
				return true;
			}
		}
		return false;
	}

	public static Connection getConnection() {
		return database.getConn();
	}

	public static ArrayList<Card> getCardlist(int owner) throws Exception {
		ArrayList<Card> resultlist = new ArrayList<Card>();
		String sql = "select * from cardinfo where isdel=? and owner=?;";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, owner);
		ResultSet rs = ps.executeQuery();
		resultlist.clear();
		while (rs.next()) {
			Card card = new Card();
			card.setId(rs.getInt(1));
			card.setName(rs.getString(2));
			card.setPositon(rs.getString(3));
			card.setTel(rs.getString(4));
			card.setEmail(rs.getString(5));
			card.setAddress(rs.getString(6));
			card.setPhotopath(rs.getString(7));
			card.setOwner(rs.getInt(8));
			card.setIsdel(rs.getInt(9));
			resultlist.add(card);
		}
		return resultlist;
	}

	public static Card getCardbyId(int id) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from cardinfo where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Card card = null;
		if (rs.next()) {
			card = new Card();
			card.setId(rs.getInt(1));
			card.setName(rs.getString(2));
			card.setPositon(rs.getString(3));
			card.setTel(rs.getString(4));
			card.setEmail(rs.getString(5));
			card.setAddress(rs.getString(6));
			card.setPhotopath(rs.getString(7));
			card.setOwner(rs.getInt(8));
			card.setIsdel(rs.getInt(9));
		}
		return card;
	}
}
