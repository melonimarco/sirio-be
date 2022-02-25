package com.accenture.sirio.facade;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoParcoRTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.ParcoSalvataggioTO;
import com.accenture.sirio.service.AnimaleService;
import com.accenture.sirio.service.ParcoNaturaleService;
import com.accenture.sirio.service.PiantaService;

@Service
public class ParcoNaturaleFacade {
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;
	
	@Autowired 
	private PiantaService piantaService;
	
	@Autowired
	private AnimaleService animaleService;
	
	

	public List<ParcoNaturaleTO> getListParchi() {
		
		return parcoNaturaleService.getListParchi();
	}

	public InfoParcoRTO getInfoParco(Long idParco) {
		
		InfoParcoRTO infoParcoRTO = new InfoParcoRTO(parcoNaturaleService.getParcoById(idParco), 
				animaleService.getListInfoAnimaleByIdParco(idParco), 
				piantaService.getListInfoPiantaTOByIdParco(idParco));

		return infoParcoRTO;
	}

	@Transactional
	public Long saveParco(ParcoSalvataggioTO parcoSalvataggioTO) {
		return parcoNaturaleService.saveParco(parcoSalvataggioTO);
	}
	
	
}
