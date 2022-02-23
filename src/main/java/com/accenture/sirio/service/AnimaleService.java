package com.accenture.sirio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.sirio.controller.BaseController;
import com.accenture.sirio.controller.PiantaController;
import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entityRTO.InfoAnimaleRTO;
import com.accenture.sirio.entityRTO.InfoCompleteAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InfoCompleteAnimaleTO;
import com.accenture.sirio.repository.AnimaleRepository;


@Service
public class AnimaleService {
	
	@Autowired
	private AnimaleRepository animaleRepository;
	
	//Metodo che salva un Animale
	@Transactional
	public Long saveAnimale(AnimaleTO animaleTO) {
		Animale save = animaleRepository.save(convertToAnimale(animaleTO));
		return save.getId();
	}
	
	//Metodo che converte un TO in una nuova Entità Animale - CREA nuovo ID
	public Animale convertToAnimale(AnimaleTO animaleTO) {
		
		Animale animale = new Animale();
		
		animale.setSpecie(animaleTO.getSpecie());
		animale.setSesso(animaleTO.getSesso());
		animale.setNumeroEsemplari(animaleTO.getNumEsemplari());
		animale.setTipoOrdineAppartenenzaAnimali(animaleTO.getTipoAnimale());
		animale.setTipoStatoSalute(animaleTO.getTipoStatoSalute());
		animale.setParcoNaturale(animaleTO.getParco());
		
		return animale;
			
	}
	
	//Metodo che controlla se sul DB esiste un animale con quelle caratteristiche - Ignora l'ID
	public Boolean checkSpecieAlreadyExist(AnimaleTO animaleTO) {
		return animaleRepository.findSpecie(animaleTO.getSpecie(), animaleTO.getSesso(), animaleTO.getParco())!=null;
	}
	
	//Metodo che prende dal DB una lista di tutti gli animali di un parco
	public List<InfoAnimaleRTO> getListInfoAnimaleByIdParco(Long idParco){
		return animaleRepository.findInfoAnimaleByIdParco(idParco);
	}

	//Metodo che prende dal DB un animale
	public InfoCompleteAnimaleRTO getAnimale(Long idAnimale) {
		
		InfoCompleteAnimaleTO findInfoCompleteAnimaleTO = animaleRepository.findInfoCompleteAnimaleById(idAnimale);
		
		InfoCompleteAnimaleRTO infoCompleteAnimaleRTO = convertToInfoAnimaleRTO(findInfoCompleteAnimaleTO);
		
		return infoCompleteAnimaleRTO;
	}
	
	
	
	private InfoCompleteAnimaleRTO convertToInfoAnimaleRTO(InfoCompleteAnimaleTO findInfoCompleteAnimaleTO) {
		
		InfoCompleteAnimaleRTO infoCompleteAnimaleRTO = new InfoCompleteAnimaleRTO();
		
		infoCompleteAnimaleRTO.setId(findInfoCompleteAnimaleTO.getId());
		infoCompleteAnimaleRTO.setTipoAnimale(findInfoCompleteAnimaleTO.getTipoAnimale());
		infoCompleteAnimaleRTO.setSpecie(findInfoCompleteAnimaleTO.getSpecie());
		infoCompleteAnimaleRTO.setSesso(findInfoCompleteAnimaleTO.getSesso());
		infoCompleteAnimaleRTO.setParco(findInfoCompleteAnimaleTO.getParco());
		infoCompleteAnimaleRTO.setTipoStatoSalute(findInfoCompleteAnimaleTO.getTipoStatoSalute());
		infoCompleteAnimaleRTO.setNumEsemplari(findInfoCompleteAnimaleTO.getNumEsemplari());
		
		return infoCompleteAnimaleRTO;
	}

	//-----Inizio gestione Edit Animale-----
	
	//Metodo che controlla se esiste a DB un animale con quelle caratteristiche - controlla ID
	public boolean checkSpecieAlreadyExistEdit(AnimaleTO animaleTO, Long idAnimale) {
		return animaleRepository.findSpecieEdit(idAnimale, animaleTO.getSpecie(), animaleTO.getSesso(), animaleTO.getParco())!=null;
	}

	//Metodo che salva le modifiche in un animale preesistente
	public Long editAnimale(AnimaleTO animaleTO, Long idAnimale) {
		
		Animale animale = animaleRepository.getById(idAnimale);
		
		Animale save = animaleRepository.save(convertToAnimaleEdit(animale, animaleTO));
		
		return save.getId();
	}

	//Metodo che converte un TO in un'Entità Animale esistente - NON crea nuovo ID
	private Animale convertToAnimaleEdit(Animale animale, AnimaleTO animaleTO) {
		
		animale.setSpecie(animaleTO.getSpecie());
		animale.setSesso(animaleTO.getSesso());
		animale.setNumeroEsemplari(animaleTO.getNumEsemplari());
		animale.setTipoOrdineAppartenenzaAnimali(animaleTO.getTipoAnimale());
		animale.setTipoStatoSalute(animaleTO.getTipoStatoSalute());
		animale.setParcoNaturale(animaleTO.getParco());
		
		return animale;
	}

	//-----Fine gestione Edit Animale-----
	
	public boolean checkIfAnimaleExist(Long idAnimale) {
		return animaleRepository.findAnimaleById(idAnimale)!=null;
	}

	public Long deleteAnimale(Long idAnimale) {
		animaleRepository.deleteById(idAnimale);
		return idAnimale;
	}

	//Cerco a db una specie con quell'id e quel parco
	//Se la trovo il parco non è stato cambiato - false
	//Se non la trovo il parco è stato cambiato - true
	public boolean checkIfParcoChanged(Long idAnimale, Long parco) {
		return animaleRepository.findIfParcoChanged(idAnimale, parco)==null;
	}

	public Long duplicateAnimale(AnimaleTO animaleTO, Long idAnimale) {
//		if(checkIfParcoChanged(idAnimale, animaleTO.getParco())) {
			return saveAnimale(animaleTO);
//		} 
//		return idAnimale;
	}
	
}
