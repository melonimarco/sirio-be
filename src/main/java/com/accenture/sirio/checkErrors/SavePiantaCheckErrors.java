package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.PiantaService;

@Service
public class SavePiantaCheckErrors extends BaseCheckErrors{
	@Autowired
	private PiantaService piantaService;
	
	public List<String> savePiantaCheck(PiantaTO piantaTO) {
		
		List<String> messaggiList = new ArrayList<>();
		
		String messaggio = piantaService.checkSpecieAlreadyExist(piantaTO, "La specie è già stata inserita");
		
		if(messaggio!=null) {
			messaggiList.add(messaggio);
		}
		
		
		return messaggiList;
		
	}
}
