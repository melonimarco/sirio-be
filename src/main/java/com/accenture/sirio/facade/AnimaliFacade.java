package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.service.AnimaliService;

@Service
public class AnimaliFacade {
	
	@Autowired
	private AnimaliService animaliService;
	
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

	public InitAnimaleTO initCreazione() {
		
		return animaliService.initCreazione();
	}

	public Long saveAnimale(AnimaleTO animaleTO) throws EmptyException {
		
		emptyLongCheck(animaleTO.getParco(), "Il campo Parco è vuoto");
		emptyLongCheck(animaleTO.getTipoAnimale(), "Il campo Tipo Animale è vuoto");
		emptyStringCheck(animaleTO.getSpecie(), "Il campo Specie è vuoto");
		emptyCharacterCheck(animaleTO.getSesso(), "Il campo Sesso è vuoto");
		emptyLongCheck(animaleTO.getTipoStatoSalute(), "Il campo Stato Salute è vuoto");
		emptyIntCheck(animaleTO.getNumEsemplari(), "Il campo Numero Esemplari è vuoto");
		
		return animaliService.saveAnimale(animaleTO);
	}
}