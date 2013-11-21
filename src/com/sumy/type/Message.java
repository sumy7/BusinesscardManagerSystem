package com.sumy.type;

public class Message {
	public static String MESSAGETYPE_SUCCESS = "success";
	public static String MESSAGETYPE_WARNING = "warning";
	public static String MESSAGETYPE_DANGER = "danger";
	public static String MESSAGETYPE_INFO = "info";

	private String message;
	private String messagetype;

	public Message() {
		message = "";
		messagetype = MESSAGETYPE_SUCCESS;
	}

	public Message(String message, String messagetype) {
		this.message = message;
		this.messagetype = messagetype;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

}
