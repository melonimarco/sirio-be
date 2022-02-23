package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.service.AnimaleService;

@Service
public class AnimaleCheckErrors extends BaseCheckErrors{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnimaleCheckErrors.class);
	
	@Autowired
	private AnimaleService animaleService;
	
	//Controllo che l'id non sia null e che sia presente a DB
	public List<String> checkIdExist(Long idAnimale) {
		LOGGER.info("Controlli campo id");
		List<String> messaggiList = new ArrayList<>();
		
		LOGGER.info("Controllo se l'id è null");
		if(idAnimale!=null) {
			LOGGER.info("Controllo se l'id è presente a DB");
			if(!animaleService.checkIfAnimaleExist(idAnimale)) {
				messaggiList.add("Id non trovato");
			}
		} else {
			messaggiList.add("l'id non può essere null");
		}
		return messaggiList;
	}
	
	//Controllo che il sesso sia stato inserito correttamente
	public List<String> checkSesso(Character sesso) {
		LOGGER.info("Controllo il campo sesso");
		List<String> messaggiList = new ArrayList<>();
		
		if(!sesso.equals('M') && !sesso.equals('F')) {
			messaggiList.add("Errore nell'inserimento del sesso");
		}
		return messaggiList;	
	}
	
	//Controllo se quella specie è già presente controllando specie, sesso e parco
	public List<String> checkSpecieAlreadyExist(AnimaleTO animaleTO) {
		LOGGER.info("Controllo se la specie è già presente nel parco");
		List<String> messaggiList = new ArrayList<>();
		
		if(animaleService.checkSpecieAlreadyExist(animaleTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		return messaggiList;
	}
	
	//Controllo se quella specie è già presente controllando id, specie, sesso e parco
	public List<String> checkSpecieAlreadyExistEdit(AnimaleTO animaleTO, Long idAnimale){
		LOGGER.info("Controllo se una specie con id diverso è già presente nel parco");
		List<String> messaggiList = new ArrayList<>();
		
		if(animaleService.checkSpecieAlreadyExistEdit(animaleTO, idAnimale)) {
			messaggiList.add("La specie esiste già");
		}
		return messaggiList;
	}
	
	//controllo che i valori arrivino maggiori di 1
	public List<String> checkValoreSelect(Long valore, String messaggio) {
		LOGGER.info("Controllo se i valori inseriti sono maggiori di 1");
		List<String> messaggiList = new ArrayList<>();
		
		if(valore<1) {
			messaggiList.add(messaggio);
		} 
		return messaggiList;
		
	}
	
	public boolean checkIfParcoChanged(Long idAnimale, Long parco) {
		LOGGER.info("Controllo se il parco è cambiato");
		
		return animaleService.checkIfParcoChanged(idAnimale, parco);
	}
	
	//---Controlli congiunti---
	
	//Controlli per save di un nuovo animale
	public List<String> saveAnimaleCheck(AnimaleTO animaleTO) {
		LOGGER.info("Controllo i campi inseriti in input per save");
		
		List<String> messaggiList = new ArrayList<>();

		messaggiList.addAll(checkSpecieAlreadyExist(animaleTO));
	
		messaggiList.addAll(checkSesso(animaleTO.getSesso()));
		
		return messaggiList;
	}

	//Controllo per Edit di un animale esistente
	public List<String> editAnimaleCheck(AnimaleTO animaleTO, Long idAnimale) {
		LOGGER.info("Controllo i campi inseriti in input per edit");
		
		List<String> messaggiList = new ArrayList<>();
		
		messaggiList.addAll(checkIdExist(idAnimale));
		
		if(messaggiList.isEmpty()) {
			messaggiList.addAll(checkSpecieAlreadyExistEdit(animaleTO, idAnimale));
			messaggiList.addAll(checkSesso(animaleTO.getSesso()));
			messaggiList.addAll(checkValoreSelect(animaleTO.getParco(), "Inserire un parco"));
			messaggiList.addAll(checkValoreSelect(animaleTO.getTipoAnimale(), "Inserire un tipo animale"));
			messaggiList.addAll(checkValoreSelect(animaleTO.getTipoStatoSalute(), "Inserire un tipo stato salute"));
		}
		
		return messaggiList;
	}
	
	//Controllo per Dupliate di un animale esistente
		public List<String> duplicateAnimaleCheck(AnimaleTO animaleTO, Long idAnimale) {
			LOGGER.info("Controllo i campi inseriti in input per duplicate");
			
			List<String> messaggiList = new ArrayList<>();
			
			messaggiList.addAll(checkIdExist(idAnimale));
			
			if(messaggiList.isEmpty()) {
				messaggiList.addAll(checkValoreSelect(animaleTO.getParco(), "Inserire un parco"));
				messaggiList.addAll(checkValoreSelect(animaleTO.getTipoAnimale(), "Inserire un tipo animale"));
				messaggiList.addAll(checkValoreSelect(animaleTO.getTipoStatoSalute(), "Inserire un tipo stato salute"));
				messaggiList.addAll(checkSesso(animaleTO.getSesso()));

//				if(checkIfParcoChanged(idAnimale, animaleTO.getParco())) {
					messaggiList.addAll(checkSpecieAlreadyExist(animaleTO));
//				} else {
//					messaggiList.addAll(checkSpecieAlreadyExistEdit(animaleTO, idAnimale));
//				}

			}
			
			return messaggiList;
		}

	
}
