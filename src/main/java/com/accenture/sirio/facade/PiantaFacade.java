package com.accenture.sirio.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.checkErrors.SavePiantaCheckErrors;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.PiantaService;

@Service
public class PiantaFacade {
	@Autowired
	private PiantaService piantaService;
	
	@Autowired
	private SavePiantaCheckErrors savePiantaCheckErrors;

	public InitPiantaTO initCreazione() {
		
		return piantaService.initCreazione();
	}
	
	public List<String> savePiantaBridge (PiantaTO piantaTO){
		
		return savePiantaCheckErrors.savePiantaCheck(piantaTO);
	}

	public Object savePianta(PiantaTO piantaTO) {
		
		return piantaService.savePianta(piantaTO);
	}
}
