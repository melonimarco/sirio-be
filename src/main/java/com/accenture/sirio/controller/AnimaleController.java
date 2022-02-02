package com.accenture.sirio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.checkErrors.SaveAnimaleCheckErrors;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.ErrorMessageTO;
import com.accenture.sirio.exceptions.EmptyException;
import com.accenture.sirio.exceptions.MinException;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.facade.AnimaleFacade;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/animale")
@RestController
public class AnimaleController extends BaseController {
	
	@Autowired
	private AnimaleFacade animaleFacade;
	
	@Autowired
	private SaveAnimaleCheckErrors saveAnimaleCheckErrors;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		return new ResponseEntity<>(animaleFacade.initCreazione(), HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<Object> saveAnimale(@Valid @RequestBody AnimaleTO animaleTO){
		
		List<String> eList = saveAnimaleCheckErrors.saveAnimaleCheck(animaleTO);
		
		if(ObjectUtils.isEmpty(eList)) {
			return new ResponseEntity<>(animaleFacade.saveAnimale(animaleTO), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@GetMapping("/{idAnimale}")
	public ResponseEntity<Object> getAnimale(@PathVariable Long idAnimale){
		
		return new ResponseEntity<>(animaleFacade.getAnimale(idAnimale), HttpStatus.OK);
	}

}
