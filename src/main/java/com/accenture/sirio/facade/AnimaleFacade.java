package com.accenture.sirio.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.checkErrors.SaveAnimaleCheckErrors;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.AnimaleService;

@Service
public class AnimaleFacade {
	
	@Autowired
	private AnimaleService animaliService;
	
	@Autowired
	private SaveAnimaleCheckErrors saveAnimaleCheckErrors;
	

	public InitAnimaleTO initCreazione() {
		return animaliService.initCreazione();
	}
	
	@Transactional
	public Long saveAnimale(AnimaleTO animaleTO){	
		return animaliService.saveAnimale(animaleTO);
	}
}
