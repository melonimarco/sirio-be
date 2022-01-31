package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.checkErrors.SavePiantaCheckErrors;
import com.accenture.sirio.entity.Pianta;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
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

	public Object savePianta(PiantaTO piantaTO) {
		
		return piantaService.savePianta(piantaTO);
	}
	
	public Pianta convertToPianta(PiantaTO piantaTO) {
		
		Pianta pianta = new Pianta();
		
		pianta.setSpecie(piantaTO.getSpecie());
		pianta.setTipoOrdineAppartenenzaPiante(piantaTO.getTipoPianta());
		pianta.setTipoStagioneFioritura(piantaTO.getStagioneFioritura());
		pianta.setParcoNaturale(piantaTO.getParco());
		return pianta;
	}
}
