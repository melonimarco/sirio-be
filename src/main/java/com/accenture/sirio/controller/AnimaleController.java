package com.accenture.sirio.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.checkErrors.AnimaleCheckErrors;
import com.accenture.sirio.entityRTO.InfoCompleteAnimaleRTO;
import com.accenture.sirio.entityRTO.InitEditAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InitAnimaleTO;
import com.accenture.sirio.facade.AnimaleFacade;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/animale")
@RestController
public class AnimaleController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnimaleController.class);
	
	@Autowired
	private AnimaleFacade animaleFacade;
	
	@Autowired
	private AnimaleCheckErrors animaleCheckErrors;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		LOGGER.info("Enter initCreazione Animale");
		
		//Metto return metodo in variabile che uso per log e return
		
		InitAnimaleTO initCreazione = animaleFacade.initCreazione();
		
		LOGGER.info("Output initCreazione Animale : " + initCreazione.toString());
		
		return new ResponseEntity<>(initCreazione, HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<Object> saveAnimale(@Valid @RequestBody AnimaleTO animaleTO){
		LOGGER.info("Enter saveAnimale");
		LOGGER.info("animaleTO in input : " + animaleTO.toString());
		
		List<String> eList = animaleCheckErrors.saveAnimaleCheck(animaleTO);
		
		if(ObjectUtils.isEmpty(eList)) {
			Long saveAnimale = animaleFacade.saveAnimale(animaleTO);
			LOGGER.info("Output saveAnimale : " + saveAnimale);
			return new ResponseEntity<>(saveAnimale, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in saveAnimale " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@GetMapping("/{idAnimale}")
	public ResponseEntity<Object> getAnimale(@PathVariable Long idAnimale){
		LOGGER.info("Enter getAnimale");
		LOGGER.info(idAnimale.toString());
		
		List<String> eList = animaleCheckErrors.checkIdExist(idAnimale);
		
		if(ObjectUtils.isEmpty(eList)) {
			InfoCompleteAnimaleRTO animale = animaleFacade.getAnimale(idAnimale);
			LOGGER.info("Output getAnimale : " + animale.toString());
			return new ResponseEntity<>(animale, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in getAnimale : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/initEdit/{idAnimale}")
	public ResponseEntity<Object> initEditAnimale(@PathVariable Long idAnimale){
		LOGGER.info("Enter initEditAnimale Animale");
		LOGGER.info("id in input : " + idAnimale.toString());
		
		List<String> eList = animaleCheckErrors.checkIdExist(idAnimale);
		
		if(ObjectUtils.isEmpty(eList)) {
			InitEditAnimaleRTO initEditAnimale = animaleFacade.initEditAnimale(idAnimale);
			LOGGER.info("Output initEditAnimale : " + initEditAnimale.toString());
			return new ResponseEntity<>(initEditAnimale, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in initEditAnimale : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{idAnimale}")
	public ResponseEntity<Object> editAnimale(@Valid @RequestBody AnimaleTO animaleTO, @PathVariable Long idAnimale){
		LOGGER.info("Enter editAnimale");
		LOGGER.info("animaleTO in input : " + animaleTO.toString());
		LOGGER.info("id in input : " + idAnimale.toString());
		
		List<String> eList = animaleCheckErrors.editAnimaleCheck(animaleTO, idAnimale);
		
		if(ObjectUtils.isEmpty(eList)) {
			Long editAnimale = animaleFacade.editAnimale(animaleTO, idAnimale);
			LOGGER.info("Output editAnimale: " + editAnimale.toString());
			return new ResponseEntity<>(editAnimale, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in editAnimale : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping("/{idAnimale}")
	public ResponseEntity<Object> deleteAnimale(@PathVariable Long idAnimale){
		LOGGER.info("Enter deleteAnimale Animale");
		LOGGER.info(idAnimale.toString());
		
		List<String> eList = animaleCheckErrors.checkIdExist(idAnimale);
		
		if(ObjectUtils.isEmpty(eList)) {
			Long deleteAnimale = animaleFacade.deleteAnimale(idAnimale);
			LOGGER.info("Output deleteAnimale : " + deleteAnimale.toString());
			return new ResponseEntity<>(deleteAnimale, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in deleteAnimale : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
