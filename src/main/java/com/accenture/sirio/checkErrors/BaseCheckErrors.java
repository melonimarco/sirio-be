package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;

public class BaseCheckErrors {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseCheckErrors.class);
	
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
	
	//controllo che i valori arrivino maggiori di 1
	public List<String> checkValoreSelect(Long valore, String messaggio) {
		LOGGER.info("Controllo se i valori inseriti sono maggiori di 1");
		List<String> messaggiList = new ArrayList<>();
			
		if(valore<1) {
			messaggiList.add(messaggio);
		} 
		return messaggiList;
			
	}
}
