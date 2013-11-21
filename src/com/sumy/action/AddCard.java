package com.sumy.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.MyUnicodeStringSource;
import com.sumy.tools.RandomString;
import com.sumy.tools.SessionOperationAdapter;
import com.sumy.tools.UploadFileSave;
import com.sumy.type.Card;
import com.sumy.type.Message;
import com.sumy.type.OnlineUser;

public class AddCard extends ActionSupport {
	private Card usercard = new Card();
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public Message mess = null;

	public Card getUsercard() {
		return usercard;
	}

	public void setUsercard(Card usercard) {
		this.usercard = usercard;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Override
	public String execute() throws Exception {
		OnlineUser visitor = SessionOperationAdapter.sessionGetUser();

		if (usercard.getName() == null || usercard.getName().equals("")) {
			mess = new Message(
					MyUnicodeStringSource.getValue("card_infoerror"),
					Message.MESSAGETYPE_WARNING);
			return "badcard";
		}
		String Filename;
		if (upload == null) {
			Filename = "";
		} else {
			Filename = RandomString.randomString(20)
					+ uploadFileName
							.substring(uploadFileName.lastIndexOf(".") - 1);
			UploadFileSave.SavaFile(upload, uploadFileName, uploadContentType,
					Filename);
		}
		Database.insertNewCard(usercard, Filename, visitor.getId());
		mess = new Message(MyUnicodeStringSource.getValue("card_addsuccess"),
				Message.MESSAGETYPE_SUCCESS);
		return "success";
	}

	public String redirect() throws Exception {
		return "success";
	}
}
