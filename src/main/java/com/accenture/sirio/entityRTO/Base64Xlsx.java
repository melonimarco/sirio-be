package com.accenture.sirio.entityRTO;

public class Base64Xlsx {
	private String base64;
	private String fileName;
	private String mimeType;

	public Base64Xlsx() {
		super();
	}

	public Base64Xlsx(String base64, String fileName, String mimeType) {
		super();
		this.base64 = base64;
		this.fileName = fileName;
		this.mimeType = mimeType;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	
	
	
}
