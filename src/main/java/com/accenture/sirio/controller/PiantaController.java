package com.accenture.sirio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.facade.PianteFacade;
import com.accenture.sirio.facade.TipoEntitaInserimentoFacade;



@RequestMapping(path="/pianta")
@RestController
public class PiantaController {
	@Autowired
	private PianteFacade piantaFacade;
	
	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		return new ResponseEntity<>(piantaFacade.initCreazione(), HttpStatus.OK);
	}
	

}
