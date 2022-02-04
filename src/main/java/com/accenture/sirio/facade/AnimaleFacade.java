package com.accenture.sirio.facade;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.entityRTO.InfoCompleteAnimaleRTO;
import com.accenture.sirio.entityRTO.InitEditAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.service.AnimaleService;
import com.accenture.sirio.service.ParcoNaturaleService;
import com.accenture.sirio.service.TipoEntitaInserimentoService;
import com.accenture.sirio.service.TipoOrdineAppartenenzaAnimaleService;
import com.accenture.sirio.service.TipoStatoSaluteService;

@Service
public class AnimaleFacade {
	
	@Autowired
	private AnimaleService animaleService;

	@Autowired
	private TipoEntitaInserimentoService tipoEntitaInserimentoService;
	
	@Autowired
	private TipoStatoSaluteService tipoStatoSaluteService;
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaleService tipoOrdineAppartenenzaAnimaleService;
	
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;
	

	public InitAnimaleTO initCreazione() {
		
		InitAnimaleTO initAnimaleTO = new InitAnimaleTO(tipoEntitaInserimentoService.getListEntitaInserimento(), 
				tipoStatoSaluteService.getListStatiSalute(), 
				tipoOrdineAppartenenzaAnimaleService.getListOrdAppAnimale(), 
				parcoNaturaleService.getListParchi());
		
		return initAnimaleTO;
	}
	
	@Transactional
	public Long saveAnimale(AnimaleTO animaleTO){	
		return animaleService.saveAnimale(animaleTO);
	}

	public InfoCompleteAnimaleRTO getAnimale(Long idAnimale) {
		
		return animaleService.getAnimale(idAnimale);
	}

	public InitEditAnimaleRTO initEditAnimale(Long idAnimale) {
		
		InitEditAnimaleRTO initEditAnimaleRTO = new InitEditAnimaleRTO(tipoEntitaInserimentoService.getListEntitaInserimento(), 
				tipoStatoSaluteService.getListStatiSalute(), tipoOrdineAppartenenzaAnimaleService.getListOrdAppAnimale(),
				parcoNaturaleService.getListParchi(), animaleService.getAnimale(idAnimale));
		
		return initEditAnimaleRTO;
	}

	@Transactional
	public Object editAnimale(AnimaleTO animaleTO, Long idAnimale) {
		return animaleService.editAnimale(animaleTO, idAnimale);
	}
	
}
