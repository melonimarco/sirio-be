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

import com.accenture.sirio.checkErrors.PiantaCheckErrors;
import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityRTO.InitEditPiantaRTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.facade.PiantaFacade;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/pianta")
@RestController
public class PiantaController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PiantaController.class);
	
	@Autowired
	private PiantaFacade piantaFacade;
	
	@Autowired
	private PiantaCheckErrors piantaCheckErrors;
	
	//Restituisce i dati per il form del save
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		LOGGER.info("Enter initCreazione Pianta");
		InitPiantaTO initCreazione = piantaFacade.initCreazione();
		LOGGER.info("Output initCreazione Pianta : " + initCreazione.toString());
		return new ResponseEntity<>(initCreazione, HttpStatus.OK);
	}
	
	//Save pianta
	@PostMapping()
	public ResponseEntity<Object> savePianta(@Valid @RequestBody PiantaTO piantaTO){
		//Più {} = più parametri
		LOGGER.info("Enter savePianta {}" , piantaTO.toString());
//		LOGGER.info("piantaTO in input : " );
		List<String> eList = piantaCheckErrors.checkSpecieAlreadyExist(piantaTO);
		
		if(ObjectUtils.isEmpty(eList)) {
			Long savePianta = piantaFacade.savePianta(piantaTO);
			LOGGER.info("Output savePianta : " + savePianta.toString());
			return new ResponseEntity<>(savePianta, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in savePianta : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
			
	}
	
	//Dettaglio pianta
	@GetMapping("/{idPianta}")
	public ResponseEntity<Object> getPianta(@PathVariable Long idPianta){
		LOGGER.info("Enter getPianta");
		LOGGER.info("IdPianta in input : " + idPianta.toString());
		
		List<String> eList = piantaCheckErrors.checkIdExist(idPianta);
		
		if(ObjectUtils.isEmpty(eList)) {
			InfoCompletePiantaRTO pianta = piantaFacade.getPianta(idPianta);
			LOGGER.info("Output getPianta : " + pianta.toString());
			return new ResponseEntity<>(pianta, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in getPianta : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	//Restituisce dati per form edit
	@GetMapping("/initEdit/{idPianta}")
	public ResponseEntity<Object> initEditPianta(@PathVariable Long idPianta){
		LOGGER.info("Enter initEditPianta");
		LOGGER.info("IdPianta in input : " + idPianta.toString());
		
		List<String> eList = piantaCheckErrors.checkIdExist(idPianta);
		
		if(ObjectUtils.isEmpty(eList)) {
			InitEditPiantaRTO initEditPianta = piantaFacade.initEditPianta(idPianta);
			LOGGER.info("Output initEditPiantas : " + initEditPianta.toString());
			return new ResponseEntity<>(initEditPianta, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in initEditPianta : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		
	}
	
	@PutMapping("/{idPianta}")
	public ResponseEntity<Object> editPianta(@Valid @RequestBody PiantaTO piantaTO, @PathVariable Long idPianta){
		LOGGER.info("Enter editPianta");
		LOGGER.info("piantaTO in input : " + piantaTO.toString());
		LOGGER.info("IdPianta in input : " + idPianta.toString());
		
		List<String> eList = piantaCheckErrors.editPiantaCheck(piantaTO, idPianta);
		
		if(ObjectUtils.isEmpty(eList)) {
			return new ResponseEntity<>(piantaFacade.editPianta(piantaTO, idPianta), HttpStatus.OK);
		} else {
			LOGGER.error("Errori in editPianta : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping("/{idPianta}")
	public ResponseEntity<Object> deletePianta(@PathVariable Long idPianta){
		LOGGER.info("Enter deletePianta");
		LOGGER.info("IdPianta in input : " + idPianta.toString());
		
		List<String> eList = piantaCheckErrors.checkIdExist(idPianta);
		
		if(ObjectUtils.isEmpty(eList)) {
			Long deletePianta = piantaFacade.deletePianta(idPianta);
			LOGGER.info("Output deletePianta : " + deletePianta.toString());
			return new ResponseEntity<>(deletePianta, HttpStatus.OK);
		} else {
			LOGGER.error("Errori in deletePianta : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
