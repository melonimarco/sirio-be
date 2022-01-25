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
	
	public void savePiantaCheck(PiantaTO piantaTO) throws SpecieAlreadyExistException {
		
		piantaService.checkSpecieAlreadyExist(piantaTO.getSpecie(), "La specie è già stata inserita");
		
	}
}
