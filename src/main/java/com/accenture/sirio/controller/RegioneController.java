package com.accenture.sirio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sirio.entity.Regione;
import com.accenture.sirio.repository.RegioneRepository;


@RequestMapping(path="/regioni")
@RestController
public class RegioneController {
	@Autowired
	private RegioneRepository regioneRepository;

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Regione> getRegioni(){
		return regioneRepository.findAll();
	}


}
