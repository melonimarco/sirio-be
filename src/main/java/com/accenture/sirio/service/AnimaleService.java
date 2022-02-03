package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entityRTO.InfoAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InfoCompleteAnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;
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
	private AnimaleRepository animaleRepository;
	
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
		
		Animale save = animaleRepository.save(convertTOAnimale(animaleTO));
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

		return animaleRepository.findSpecie(animaleTO.getSpecie(), animaleTO.getSesso(), animaleTO.getParco())!=null;
		
	}
	
	public List<InfoAnimaleRTO> getListInfoAnimaleByIdParco(Long idParco){
		return animaleRepository.findInfoAnimaleByIdParco(idParco);
	}

	//Query con join e inserimento da costruttore
	public InfoCompleteAnimaleTO getAnimale(Long idAnimale) {
		
		AnimaleTO animaleTO = animaleRepository.findAnimaleById(idAnimale);
		
		TipoOrdineAppartenenzaAnimaleTO tipoAnimale = tipoOrdineAppartenenzaAnimaliRepository.findOrdineAppAnimaliById(animaleTO.getTipoAnimale());
		ParcoNaturaleTO parco = parcoNaturaleRepository.findParcoById(animaleTO.getParco());
		TipoStatoSaluteTO tipoStatoSalute = tipoStatoSaluteRepository.findStatoSaluteById(animaleTO.getTipoStatoSalute());
		
		InfoCompleteAnimaleTO infoCompleteAnimaleTO = new InfoCompleteAnimaleTO();
		
		infoCompleteAnimaleTO.setId(animaleTO.getId());
		infoCompleteAnimaleTO.setTipoAnimale(tipoAnimale);
		infoCompleteAnimaleTO.setSpecie(animaleTO.getSpecie());
		infoCompleteAnimaleTO.setSesso(animaleTO.getSesso());
		infoCompleteAnimaleTO.setParco(parco);
		infoCompleteAnimaleTO.setTipoStatoSalute(tipoStatoSalute);
		infoCompleteAnimaleTO.setNumEsemplari(animaleTO.getNumEsemplari());
		
		return infoCompleteAnimaleTO;
	}
	
	
}
