package com.sumy.type;

import java.io.Serializable;

public class OnlineUser implements Serializable {

	private static final long serialVersionUID = -1453436025062204720L;
	private int id;
	private String username;
	private int power;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
