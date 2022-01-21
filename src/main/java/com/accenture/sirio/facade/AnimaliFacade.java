package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.service.AnimaliService;
import com.accenture.sirio.service.PianteService;

@Service
public class AnimaliFacade {
	
	@Autowired
	private AnimaliService animaliService;

	public InitAnimaleTO initCreazione() {
		
		return animaliService.initCreazione();
	}
}
