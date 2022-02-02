package com.accenture.sirio.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.accenture.sirio.checkErrors.SavePiantaCheckErrors;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.facade.PiantaFacade;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/pianta")
@RestController
public class PiantaController extends BaseController {
	@Autowired
	private PiantaFacade piantaFacade;
	
	@Autowired
	private SavePiantaCheckErrors savePiantaCheckErrors;
	

	@GetMapping(path="/getInitCreazione")
	public ResponseEntity<Object> getInitCreazione(){
		return new ResponseEntity<>(piantaFacade.initCreazione(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> savePianta(@Valid @RequestBody PiantaTO piantaTO){
		
		List<String> eList = savePiantaCheckErrors.savePiantaCheck(piantaTO);
		
		if(ObjectUtils.isEmpty(eList)) {
			return new ResponseEntity<>(piantaFacade.savePianta(piantaTO), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(eList, HttpStatus.UNPROCESSABLE_ENTITY);
		}
			
	}
	
	@GetMapping("/{idPianta}")
	public ResponseEntity<Object> getPianta(@PathVariable Long idPianta){
		return new ResponseEntity<>(piantaFacade.getPianta(idPianta), HttpStatus.OK);
	}

}
