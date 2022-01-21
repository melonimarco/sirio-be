package com.accenture.sirio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;
import com.fasterxml.jackson.annotation.JsonProperty;



@RequestMapping(path="/parco")
@RestController
public class ParcoController {
	@Autowired
	private TipoEntitaInserimentoFacade tipoEntitaInserimentoFacade;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		
		Map<String, List<TipoEntitaInserimentoTO>> response = new HashMap<>();
		response.put("listTipoEntita", tipoEntitaInserimentoFacade.findAll());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
