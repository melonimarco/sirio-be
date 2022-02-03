package com.accenture.sirio.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.entityRTO.InfoCompleteAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.service.AnimaleService;

@Service
public class AnimaleFacade {
	
	@Autowired
	private AnimaleService animaleService;

	

	public InitAnimaleTO initCreazione() {
		return animaleService.initCreazione();
	}
	
	@Transactional
	public Long saveAnimale(AnimaleTO animaleTO){	
		return animaleService.saveAnimale(animaleTO);
	}

	public InfoCompleteAnimaleRTO getAnimale(Long idAnimale) {
		
		return animaleService.getAnimale(idAnimale);
	}
	
}
