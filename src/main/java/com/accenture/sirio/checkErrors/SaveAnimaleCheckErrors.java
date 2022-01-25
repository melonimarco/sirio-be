package com.accenture.sirio.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.service.AnimaliService;

@Service
public class SaveAnimaleCheckErrors extends BaseCheckErrors{
	
	@Autowired
	private AnimaliService animaliService;
	
	public void saveAnimaleCheck(AnimaleTO animaleTO) throws SpecieAlreadyExistException {

		animaliService.findSpecie(animaleTO, "La specie è già stata inserita");
	}
}
