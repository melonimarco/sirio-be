package com.accenture.sirio.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.InfoParcoTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.service.ParcoNaturaleService;

@Service
public class ParcoNaturaleFacade {
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;

	public List<ParcoNaturaleTO> getListParchi() {
		return parcoNaturaleService.getListParchi();
	}

	public InfoParcoTO getInfoParco(Long idParco) {
		
		return parcoNaturaleService.getInfoParco(idParco);
	}
	
	
}
