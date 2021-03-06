package com.accenture.sirio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;



@RequestMapping(path="/parco")
@RestController
public class BaseController {
	@Autowired
	private TipoEntitaInserimentoFacade tipoEntitaInserimentoFacade;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getgetInitCreazione(){
		return new ResponseEntity<>(tipoEntitaInserimentoFacade.findAll(), HttpStatus.OK);
	}


}
