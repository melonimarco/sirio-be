package com.accenture.sirio.entityTO;

import java.util.List;

public class ErrorMessageTO {
	
	private String messaggio;
	
//	private List<String> messaggiList;

	public ErrorMessageTO() {
		super();
	}
	
//	public ErrorMessageTO(List<String> messaggiList) {
//		super();
//		this.messaggiList = messaggiList;
//	}

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

//	public List<String> getMessaggiList() {
//		return messaggiList;
//	}
//
//	public void setMessaggiList(List<String> messaggiList) {
//		this.messaggiList = messaggiList;
//	}
	
	
	
}