package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.service.ParcoNaturaleService;

@Service
public class ParcoCheckErrors {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParcoCheckErrors.class);
	
	@Autowired
	private ParcoNaturaleService parcoService;
	
	public List<String> checkIdExist(Long idParco) {
		LOGGER.info("Controllo tramite l'id che il parco sia presente a DB");
		List<String> messaggiList = new ArrayList<>();
		
		if(parcoService.getParcoById(idParco)==null) {
			messaggiList.add("Id non trovato");
		}
		
		return messaggiList;
	}
	
}
