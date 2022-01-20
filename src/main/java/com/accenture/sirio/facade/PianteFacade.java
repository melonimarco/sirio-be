package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.service.PianteService;

@Service
public class PianteFacade {
	@Autowired
	private PianteService piantaService;

	public InitPiantaTO initCreazione() {
		
		return piantaService.initCreazione();
	}
}
