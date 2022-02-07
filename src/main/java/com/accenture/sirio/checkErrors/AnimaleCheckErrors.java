package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.AnimaleService;

@Service
public class AnimaleCheckErrors extends BaseCheckErrors{
	
	@Autowired
	private AnimaleService animaliService;
	
	public List<String> saveAnimaleCheck(AnimaleTO animaleTO) {

		
		List<String> messaggiList = new ArrayList<>();
		
		if(animaliService.checkSpecieAlreadyExist(animaleTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		
		Character sesso = animaleTO.getSesso();
		if(!sesso.equals('M') && !sesso.equals('F')) {
			messaggiList.add("Errore nell'inserimento del sesso");
		}
		
		return messaggiList;
	}

	public List<String> editAnimaleCheck(AnimaleTO animaleTO, Long idAnimale) {
		List<String> messaggiList = new ArrayList<>();
		
		if(idAnimale!=null) {
			
			if(animaliService.checkSpecieAlreadyExistEdit(animaleTO, idAnimale)) {
				messaggiList.add("La specie è già stata inserita");
			}
		
			Character sesso = animaleTO.getSesso();
			if(!sesso.equals('M') && !sesso.equals('F')) {
				messaggiList.add("Errore nell'inserimento del sesso");
			}
		
		} else {
			messaggiList.add("L'id non può essere null");
		}
		
		return messaggiList;
	}

	public List<String> deleteAnimaleCheck(Long idAnimale) {
		
		List<String> messaggiList = new ArrayList<>();
		
		if(idAnimale!=null) {
			
			if(!animaliService.checkIfSpecieExist(idAnimale)) {
				messaggiList.add("L'animale non è stato trovato");
			}

		} else {
			messaggiList.add("L'id non può essere null");
		}
			
		return messaggiList;
	}
}
