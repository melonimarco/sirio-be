package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.AnimaleService;

@Service
public class SaveAnimaleCheckErrors extends BaseCheckErrors{
	
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
}
