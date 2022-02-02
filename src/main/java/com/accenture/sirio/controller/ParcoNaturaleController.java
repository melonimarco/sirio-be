package com.accenture.sirio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.entityTO.ListTipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.facade.ParcoNaturaleFacade;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;
import com.fasterxml.jackson.annotation.JsonProperty;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/parco")
@RestController
public class ParcoNaturaleController {
	@Autowired
	private TipoEntitaInserimentoFacade tipoEntitaInserimentoFacade;
	
	@Autowired
	private ParcoNaturaleFacade parcoNaturaleFacade;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		
		ListTipoEntitaInserimentoTO listTipoEntitaInserimentoTO = new ListTipoEntitaInserimentoTO();
		
		listTipoEntitaInserimentoTO.setListTipoEntita(tipoEntitaInserimentoFacade.findAll());
		
		return new ResponseEntity<>(listTipoEntitaInserimentoTO, HttpStatus.OK);
	}
	
	@GetMapping(path="/getListParchi")
	public ResponseEntity<Object> getListParchi(){
		
		Map<String, List<ParcoNaturaleTO>> response = new HashMap<>();
		response.put("listParchi", parcoNaturaleFacade.getListParchi());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path="/getInfoParco/{idParco}")
	public ResponseEntity<Object> getInfoParco(@PathVariable Long idParco){
		
		return new ResponseEntity<>(parcoNaturaleFacade.getInfoParco(idParco), HttpStatus.OK);
	}

}
