package com.accenture.sirio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.ErrorMessageTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.facade.PianteFacade;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/pianta")
@RestController
public class PianteController {
	@Autowired
	private PianteFacade piantaFacade;

	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		return new ResponseEntity<>(piantaFacade.initCreazione(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> savePianta(@RequestBody PiantaTO piantaTO){
		
		List<String> eList = new ArrayList<>();
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PiantaTO>> violations = validator.validate(piantaTO);
		
		for (ConstraintViolation<PiantaTO> violation : violations) {
		    eList.add(violation.getMessage()); 
		}
		
		try {
			
			return new ResponseEntity<>(piantaFacade.savePianta(piantaTO), HttpStatus.OK);
		} catch (SpecieAlreadyExistException e) {
			
			e.printStackTrace();
			eList.add(e.getMessage());

		}
		return new ResponseEntity<>(eList, HttpStatus.BAD_REQUEST);
	}

}
