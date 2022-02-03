package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.service.PiantaService;

@Service
public class PiantaFacade {
	@Autowired
	private PiantaService piantaService;

	public InitPiantaTO initCreazione() {
		
		return piantaService.initCreazione();
	}

	public Object savePianta(PiantaTO piantaTO) {
		
		return piantaService.savePianta(piantaTO);
	}

	public InfoCompletePiantaRTO getPianta(Long idPianta) {
		return piantaService.getPianta(idPianta);
	}
	
	
}
