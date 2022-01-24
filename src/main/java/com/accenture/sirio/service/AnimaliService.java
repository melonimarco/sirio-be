package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.entity.Animali;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.repository.AnimaliRepository;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaliRepository;
import com.accenture.sirio.repository.TipoStatoSaluteRepository;

@Service
public class AnimaliService {

	@Autowired
	private AnimaliRepository animaliRepository;
	
	@Autowired
	private TipoEntitaInserimentoRepository tipoEntitaInserimentoRepository;
	
	@Autowired
	private TipoStatoSaluteRepository tipoStatoSaluteRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaliRepository tipoOrdineAppartenenzaAnimaliRepository;
	
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
		
		Animali animale = new Animali(animaleTO);
		Animali save = animaliRepository.save(animale);
		return save.getId();
		
	}
	
	public void findSpecie(String specie, String messaggio) throws SpecieAlreadyExistException {
		
		String AnimaleFound = animaliRepository.findSpecie(specie);
		
		if(AnimaleFound!=null && !AnimaleFound.isEmpty() && AnimaleFound.equalsIgnoreCase(specie)) {
			throw new SpecieAlreadyExistException(messaggio);
		}
	}
	
	
}
