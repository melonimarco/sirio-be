package com.accenture.sirio.facade;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoParcoRTO;
import com.accenture.sirio.entityRTO.InitEditParcoRTO;
import com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO;
import com.accenture.sirio.entityTO.ListRegioniTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.ParcoSalvataggioTO;
import com.accenture.sirio.entityTO.RegioneTO;
import com.accenture.sirio.service.AnimaleService;
import com.accenture.sirio.service.ParcoNaturaleService;
import com.accenture.sirio.service.PiantaService;
import com.accenture.sirio.service.RegioneService;

@Service
public class ParcoNaturaleFacade {
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;
	
	@Autowired 
	private PiantaService piantaService;
	
	@Autowired
	private AnimaleService animaleService;
	
	@Autowired
	private RegioneService regioneService;
	
	public List<ParcoNaturaleCompletoRTO> getListParchiCompleti() {
		return parcoNaturaleService.getListParchiCompleti();
	}

	public InfoParcoRTO getInfoParco(Long idParco) {
		
		InfoParcoRTO infoParcoRTO = new InfoParcoRTO(parcoNaturaleService.getParcoCompletoById(idParco), //getParcoCompletoById
				animaleService.getListInfoAnimaleByIdParco(idParco), 
				piantaService.getListInfoPiantaTOByIdParco(idParco));

		return infoParcoRTO;
	}

	@Transactional
	public Long saveParco(ParcoSalvataggioTO parcoSalvataggioTO) {
		return parcoNaturaleService.saveParco(parcoSalvataggioTO);
	}

	public InitEditParcoRTO getInitEditParco(Long idParco) {
		ParcoSalvataggioTO parcoSalvataggioTO = new ParcoSalvataggioTO(); 
		parcoSalvataggioTO = parcoNaturaleService.getDettaglioParcoPerEdit(idParco);
		
		ListRegioniTO listRegioniTO = new ListRegioniTO();
		listRegioniTO.setListRegioni(regioneService.getListRegioni());
		
		InitEditParcoRTO InitEditParcoRTO = new InitEditParcoRTO(listRegioniTO, parcoSalvataggioTO);
		
		return InitEditParcoRTO;
	}
	
	@Transactional
	public Long editParco(ParcoSalvataggioTO parcoSalvataggioTO, Long idParco) {
		return parcoNaturaleService.editParco(parcoSalvataggioTO, idParco);
	}
	
	
}
