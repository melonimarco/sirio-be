package com.accenture.sirio.exceptions;

public class SpecieAlreadyExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public SpecieAlreadyExistException(String message) {
		super();
		this.message = message;
	}

	public SpecieAlreadyExistException() {
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
