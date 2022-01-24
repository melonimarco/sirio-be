package com.accenture.sirio.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.PianteService;

@Service
public class SavePiantaCheckErrors extends BaseCheckErrors{
	@Autowired
	private PianteService piantaService;
	
	public void savePiantaCheck(PiantaTO piantaTO) throws EmptyException, SpecieAlreadyExistException {
		
		emptyLongCheck(piantaTO.getParco(), "Il campo Parco è vuoto");
		emptyLongCheck(piantaTO.getTipoPianta(), "Il campo Tipo Pianta è vuoto");
		emptyStringCheck(piantaTO.getSpecie(), "Il campo Specie è vuoto");
		emptyLongCheck(piantaTO.getStagioneFioritura(), "Il campo Stagione Fioritura è vuoto");
		piantaService.checkSpecieAlreadyExist(piantaTO.getSpecie(), "La specie è già stata inserita");
		
	}
}
