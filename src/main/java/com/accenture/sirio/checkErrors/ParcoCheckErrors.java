package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.service.ParcoNaturaleService;

@Service
public class ParcoCheckErrors {
	
	@Autowired
	private ParcoNaturaleService parcoService;
	
	public List<String> checkIdExist(Long idParco) {
		
		List<String> messaggiList = new ArrayList<>();
		
		if(parcoService.getParcoById(idParco)==null) {
			messaggiList.add("Id non trovato");
		}
		
		return messaggiList;
	}
	
}
