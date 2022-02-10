package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.service.AnimaleService;

@Service
public class AnimaleCheckErrors extends BaseCheckErrors{
	
	@Autowired
	private AnimaleService animaleService;
	
	//Controllo che l'id non sia null e che sia presente a DB
	public List<String> checkIdExist(Long idAnimale) {
		
		List<String> messaggiList = new ArrayList<>();
		
		if(idAnimale!=null) {
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
		
		List<String> messaggiList = new ArrayList<>();
		
		if(!sesso.equals('M') && !sesso.equals('F')) {
			messaggiList.add("Errore nell'inserimento del sesso");
		}
		return messaggiList;	
	}
	
	//Controllo se quella specie è già presente controllando specie, sesso e parco
	public List<String> checkSpecieAlreadyExist(AnimaleTO animaleTO) {
		
		List<String> messaggiList = new ArrayList<>();
		
		if(animaleService.checkSpecieAlreadyExist(animaleTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		return messaggiList;
	}
	
	//Controllo se quella specie è già presente controllando id, specie, sesso e parco
	public List<String> checkSpecieAlreadyExistEdit(AnimaleTO animaleTO, Long idAnimale){
		
		List<String> messaggiList = new ArrayList<>();
		
		if(animaleService.checkSpecieAlreadyExistEdit(animaleTO, idAnimale)) {
			messaggiList.add("La specie esiste già");
		}
		return messaggiList;
	}
	
	//---Controlli congiunti---
	
	//Controlli per save di un nuovo animale
	public List<String> saveAnimaleCheck(AnimaleTO animaleTO) {
		List<String> messaggiList = new ArrayList<>();

		messaggiList.addAll(checkSpecieAlreadyExist(animaleTO));
	
		messaggiList.addAll(checkSesso(animaleTO.getSesso()));
		
		return messaggiList;
	}

	//Controllo per Edit di un animale esistente
	public List<String> editAnimaleCheck(AnimaleTO animaleTO, Long idAnimale) {
		
		List<String> messaggiList = new ArrayList<>();
		
		messaggiList.addAll(checkIdExist(idAnimale));
		
		if(messaggiList.isEmpty()) {
			messaggiList.addAll(checkSpecieAlreadyExistEdit(animaleTO, idAnimale));
			messaggiList.addAll(checkSesso(animaleTO.getSesso()));
		}
		
		return messaggiList;
	}

	
}
