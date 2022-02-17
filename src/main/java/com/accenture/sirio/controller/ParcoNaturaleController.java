package com.accenture.sirio.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.checkErrors.ParcoCheckErrors;
import com.accenture.sirio.entityRTO.InfoParcoRTO;
import com.accenture.sirio.entityTO.ListParchiTO;
import com.accenture.sirio.entityTO.ListTipoEntitaInserimentoTO;
import com.accenture.sirio.facade.ParcoNaturaleFacade;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;
import com.accenture.sirio.facade.XlsInfoParchiFacade;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/parco")
@RestController
public class ParcoNaturaleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PiantaController.class);
	
	@Autowired
	private TipoEntitaInserimentoFacade tipoEntitaInserimentoFacade;
	
	@Autowired
	private ParcoNaturaleFacade parcoNaturaleFacade;
	
	@Autowired
	private ParcoCheckErrors parcoCheckErrors;
	
	@Autowired
	private XlsInfoParchiFacade xlsInfoParchiFacade;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		LOGGER.info("Enter getInitCreazione Parco");
		ListTipoEntitaInserimentoTO listTipoEntitaInserimentoTO = new ListTipoEntitaInserimentoTO();
		
		listTipoEntitaInserimentoTO.setListTipoEntita(tipoEntitaInserimentoFacade.getListEntitaInserimento());
		
		LOGGER.info("Output getInitCreazione : " + listTipoEntitaInserimentoTO.toString());
		
		return new ResponseEntity<>(listTipoEntitaInserimentoTO, HttpStatus.OK);
	}
	
	@GetMapping(path="/getListParchi")
	public ResponseEntity<Object> getListParchi(){
		LOGGER.info("Enter getListParchi");
		ListParchiTO listParchiTO = new ListParchiTO();
		
		listParchiTO.setListParchi(parcoNaturaleFacade.getListParchi());
		
		LOGGER.info("Output getListParchi : " + listParchiTO.toString());
		
		return new ResponseEntity<>(listParchiTO, HttpStatus.OK);
	}
	
	@GetMapping(path="/getInfoParco/{idParco}")
	public ResponseEntity<Object> getInfoParco(@PathVariable Long idParco){
		
		LOGGER.info("Enter getInfoParco");
		LOGGER.info("idParco in input : " + idParco);
		
		List<String> eList = parcoCheckErrors.checkIdExist(idParco);
		
		if(ObjectUtils.isEmpty(eList)) {
			InfoParcoRTO infoParco = parcoNaturaleFacade.getInfoParco(idParco);
			LOGGER.info("Output getInfoParco : " + infoParco.toString());
			return new ResponseEntity<>(infoParco, HttpStatus.OK);
			} else {
				LOGGER.info("Errori di validazione in getInfoParco : " + eList.toString());
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
	}
	
	@GetMapping(path="/getXls")
	public ResponseEntity<Object> getXls(){
		try {
			return new ResponseEntity<>(xlsInfoParchiFacade.createXls(), HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
	
	

}
