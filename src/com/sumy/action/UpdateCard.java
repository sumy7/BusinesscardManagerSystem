package com.sumy.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.sumy.dao.Database;
import com.sumy.tools.RandomString;
import com.sumy.tools.UploadFileSave;
import com.sumy.type.Card;

public class UpdateCard extends ActionSupport {
	Card usercard = new Card();
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

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
		String Filename;
		if (upload == null) {
			Filename = null;
		} else {
			Filename = RandomString.randomString(20)
					+ uploadFileName
							.substring(uploadFileName.lastIndexOf(".") - 1);
			UploadFileSave.SavaFile(upload, uploadFileName, uploadContentType,
					Filename);
		}
		Database.modifyCard(usercard, Filename);
		return "success";
	}

}
