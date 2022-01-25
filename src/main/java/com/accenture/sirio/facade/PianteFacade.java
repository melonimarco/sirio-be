package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.checkErrors.SavePiantaCheckErrors;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.PianteService;

@Service
public class PianteFacade {
	@Autowired
	private PianteService piantaService;
	
	@Autowired
	private SavePiantaCheckErrors savePiantaCheckErrors;

	public InitPiantaTO initCreazione() {
		
		return piantaService.initCreazione();
	}

	public Object savePianta(PiantaTO piantaTO) throws SpecieAlreadyExistException {
		
		savePiantaCheckErrors.savePiantaCheck(piantaTO);
		
		return piantaService.savePianta(piantaTO);
	}
}
