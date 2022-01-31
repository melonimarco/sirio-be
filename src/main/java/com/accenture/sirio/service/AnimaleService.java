package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.facade.AnimaleFacade;
import com.accenture.sirio.repository.AnimaleRepository;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaleRepository;
import com.accenture.sirio.repository.TipoStatoSaluteRepository;

@Service
public class AnimaleService {

	@Autowired
	private AnimaleRepository animaliRepository;
	
	@Autowired
	private TipoEntitaInserimentoRepository tipoEntitaInserimentoRepository;
	
	@Autowired
	private TipoStatoSaluteRepository tipoStatoSaluteRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaleRepository tipoOrdineAppartenenzaAnimaliRepository;
	
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;

	public InitAnimaleTO initCreazione() {
		
		InitAnimaleTO initAnimaleTO = new InitAnimaleTO(tipoEntitaInserimentoRepository.findAllEntita(), 
				tipoStatoSaluteRepository.findAllStatiSalute(), 
				tipoOrdineAppartenenzaAnimaliRepository.findAllOrdiniAppAnimali(), 
				parcoNaturaleRepository.findAllParchi());
		
		return initAnimaleTO ;
	}
	
	@Transactional
	public Long saveAnimale(AnimaleTO animaleTO) {
		
		Animale save = animaliRepository.save(convertTOAnimale(animaleTO));
		return save.getId();
		
	}
	
	public Animale convertTOAnimale(AnimaleTO animaleTO) {
		
		Animale animale = new Animale();
		
		animale.setSpecie(animaleTO.getSpecie());
		animale.setSesso(animaleTO.getSesso());
		animale.setNumeroEsemplari(animaleTO.getNumEsemplari());
		animale.setTipoOrdineAppartenenzaAnimali(animaleTO.getTipoAnimale());
		animale.setTipoStatoSalute(animaleTO.getTipoStatoSalute());
		animale.setParcoNaturale(animaleTO.getParco());
		
		return animale;
			
	}
	
	public Boolean checkSpecieAlreadyExist(AnimaleTO animaleTO) {

		return animaliRepository.findSpecie(animaleTO.getSpecie(), animaleTO.getSesso(), animaleTO.getParco())!=null;
		
	}
	
	
}
