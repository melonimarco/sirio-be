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
		
		if(piantaService.checkSpecieAlreadyExist(piantaTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		
		return messaggiList;
		
	}
}
