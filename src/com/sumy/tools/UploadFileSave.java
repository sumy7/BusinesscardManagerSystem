package com.sumy.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

public class UploadFileSave {
	public static void SavaFile(File upload, String uploadFileName,
			String uploadContentType, String saveName) throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		String filename = path + File.separator + saveName;
		FileInputStream in = new FileInputStream(upload);
		FileOutputStream out = new FileOutputStream(filename);
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = in.read(b)) > 0) {
			out.write(b, 0, len);
		}
		out.close();
	}

	public static String GetFilePath(String FileName) {
		System.out.println("path:" + FileName + "---" + FileName.length());
		if (FileName.trim().length() == 0 || FileName == null)
			return "upload/default.png";
		return "upload/" + FileName;
	}
}
