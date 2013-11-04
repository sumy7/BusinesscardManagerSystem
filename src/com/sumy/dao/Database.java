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

	public static void RegistUser(String username, String password, int power)
			throws Exception {
		String sql = "insert into user(logname,passwd,power) values(?,?,?)";
		Connection conn = database.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setInt(3, power);
		ps.execute();
	}

	public static OnlineUser checkuser(String username, String password)
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
				return visitor;
			}
		}
		return null;
	}

	public static OnlineUser findUserbyname(String username) throws Exception {
		String sql = "select * from user where logname like ?;";
		Connection conn = database.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List rslist = CovertList.convertList(rs);
		for (int i = 0; i < rslist.size(); i++) {
			Map rowmap = (HashMap) rslist.get(i);
			if (rowmap.get("logname").equals(username)) {
				OnlineUser visitor = new OnlineUser();
				visitor.setId((Integer) rowmap.get("id"));
				visitor.setUsername((String) rowmap.get("logname"));
				visitor.setPower((Integer) rowmap.get("power"));
				return visitor;
			}
		}
		return null;
	}

	public static Connection getConnection() {
		return database.getConn();
	}

	public static ArrayList<Card> getCardlist(int owner, int isdel)
			throws Exception {
		ArrayList<Card> resultlist = new ArrayList<Card>();
		String sql = "select * from cardinfo where isdel=? and owner=?;";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, isdel);
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

	public static ArrayList<Card> searchCardlist(String name, String position,
			String tel, String email, String address, int owner, int isdel)
			throws Exception {
		ArrayList<Card> resultlist = new ArrayList<Card>();
		String sql = "select * from cardinfo where (name like ? or position like ? or tel like ? or email like ? or address like ?) and owner=? and isdel=?;";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		ps.setString(2, "%" + position + "%");
		ps.setString(3, "%" + tel + "%");
		ps.setString(4, "%" + email + "%");
		ps.setString(5, "%" + address + "%");
		ps.setInt(6, owner);
		ps.setInt(7, isdel);
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
			System.out.println(rs.toString());
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

	public static boolean moveCardtoRecycle(int id) throws Exception {
		Connection conn = getConnection();
		String sql = "update cardinfo set isdel=1 where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}

	public static boolean destroyCardfromRecycle(int id) throws Exception {
		Connection conn = getConnection();
		String sql = "delete from cardinfo where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}

	public static boolean moveCardtoList(int id) throws Exception {
		Connection conn = getConnection();
		String sql = "update cardinfo set isdel=0 where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		return true;
	}
}
