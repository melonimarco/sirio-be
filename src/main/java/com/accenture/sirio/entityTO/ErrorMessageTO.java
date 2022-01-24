package com.accenture.sirio.entityTO;

public class ErrorMessageTO {
	private String messaggio;

	public ErrorMessageTO() {
		super();
	}
	
	public ErrorMessageTO(String messaggio) {
		super();
		this.messaggio = messaggio;
	}
	
	
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
}