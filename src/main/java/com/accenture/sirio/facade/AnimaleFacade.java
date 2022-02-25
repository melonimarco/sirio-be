package com.accenture.sirio.facade;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.controller.AnimaleController;
import com.accenture.sirio.entityRTO.InfoCompleteAnimaleRTO;
import com.accenture.sirio.entityRTO.InitEditAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;
import com.accenture.sirio.service.AnimaleService;
import com.accenture.sirio.service.ParcoNaturaleService;
import com.accenture.sirio.service.TipoEntitaInserimentoService;
import com.accenture.sirio.service.TipoOrdineAppartenenzaAnimaleService;
import com.accenture.sirio.service.TipoStatoSaluteService;

@Service
public class AnimaleFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnimaleFacade.class);
	
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
		
		List<TipoEntitaInserimentoTO> listEntitaInserimento = tipoEntitaInserimentoService.getListEntitaInserimento();
		List<TipoStatoSaluteTO> listStatiSalute = tipoStatoSaluteService.getListStatiSalute();
		List<TipoOrdineAppartenenzaAnimaleTO> listOrdAppAnimale = tipoOrdineAppartenenzaAnimaleService.getListOrdAppAnimale();
		List<ParcoNaturaleTO> listParchi = parcoNaturaleService.getListParchi();
		
		InitAnimaleTO initAnimaleTO = new InitAnimaleTO(listEntitaInserimento, listStatiSalute,
				listOrdAppAnimale, listParchi);
		
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

		InitAnimaleTO initCreazione = initCreazione();
		InfoCompleteAnimaleRTO animale = animaleService.getAnimale(idAnimale);
		
		InitEditAnimaleRTO initEditAnimaleRTO = new InitEditAnimaleRTO(initCreazione, animale);
		
		return initEditAnimaleRTO;
	}

	@Transactional
	public Long editAnimale(AnimaleTO animaleTO, Long idAnimale) {
		return animaleService.editAnimale(animaleTO, idAnimale);
	}

	@Transactional
	public Long deleteAnimale(Long idAnimale) {
		
		return animaleService.deleteAnimale(idAnimale);
	}
	
}
