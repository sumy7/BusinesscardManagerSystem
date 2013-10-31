package com.sumy.type;

public class LoginUser {
	private String Username;
	private String Password;

	public LoginUser() {
		Username = "";
		Password = "";
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
}
