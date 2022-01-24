package com.accenture.sirio.controller;

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
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.facade.AnimaliFacade;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/animale")
@RestController
public class AnimaliController {
	@Autowired
	private AnimaliFacade animaliFacade;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		return new ResponseEntity<>(animaliFacade.initCreazione(), HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<Object> saveAnimale(@RequestBody AnimaleTO animaleTO){
		try {
			return new ResponseEntity<>(animaliFacade.saveAnimale(animaleTO), HttpStatus.OK);
		} catch (EmptyException | MinException | SpecieAlreadyExistException e) {
			
			e.printStackTrace();
			ErrorMessageTO error = new ErrorMessageTO(e.getMessage());	
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

}
