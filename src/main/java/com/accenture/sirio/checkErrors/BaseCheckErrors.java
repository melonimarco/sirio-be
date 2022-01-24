package com.accenture.sirio.checkErrors;

import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;

public class BaseCheckErrors {
	public void emptyStringCheck(String string, String messaggio) throws EmptyException {
		if(string==null || string.isEmpty()) {
			throw new EmptyException(messaggio);
		}
	}
	
	public void emptyCharacterCheck(Character ch, String messaggio) throws EmptyException {
		if(ch==null) {
			throw new EmptyException(messaggio);
		}
	}
	
	public void emptyIntCheck(Integer intInput, String messaggio) throws EmptyException {
		if(intInput==null) {
			throw new EmptyException(messaggio);
		}
	}
	
	public void emptyLongCheck(Long longInput, String messaggio) throws EmptyException {
		if(longInput==null) {
			throw new EmptyException(messaggio);
		}
	}
	
	public void minNumberCheck(Integer intInput, String messaggio) throws MinException {
		if(intInput<1) {
			throw new MinException(messaggio);
		}
	}
}
