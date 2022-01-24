package com.accenture.sirio.exceptions;

public class MinException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public MinException(String message) {
		super();
		this.message = message;
	}

	public MinException() {
		super();
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
