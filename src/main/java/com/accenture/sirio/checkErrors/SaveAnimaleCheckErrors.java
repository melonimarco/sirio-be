package com.accenture.sirio.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.AnimaliService;

@Service
public class SaveAnimaleCheckErrors extends BaseCheckErrors{
	
	@Autowired
	private AnimaliService animaliService;
	
	
	
	public void saveAnimaleCheck(AnimaleTO animaleTO) throws EmptyException, MinException, SpecieAlreadyExistException {
		emptyLongCheck(animaleTO.getParco(), "Il campo Parco è vuoto");
		emptyLongCheck(animaleTO.getTipoAnimale(), "Il campo Tipo Animale è vuoto");
		emptyStringCheck(animaleTO.getSpecie(), "Il campo Specie è vuoto");
		emptyCharacterCheck(animaleTO.getSesso(), "Il campo Sesso è vuoto");
		emptyLongCheck(animaleTO.getTipoStatoSalute(), "Il campo Stato Salute è vuoto");
		emptyIntCheck(animaleTO.getNumEsemplari(), "Il campo Numero Esemplari è vuoto");
		minNumberCheck(animaleTO.getNumEsemplari(), "Il campo Numero Esemplari non può essere inferiore a 1 ");
		animaliService.findSpecie(animaleTO.getSpecie(), "La specie è già stata inserita");
	}
}
