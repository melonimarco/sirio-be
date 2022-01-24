package com.accenture.sirio.exceptions;

public class EmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public EmptyException(String message) {
		super();
		this.message = message;
	}

	public EmptyException() {
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
