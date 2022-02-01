package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InfoParcoTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.repository.AnimaleRepository;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.PiantaRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaleRepository;

@Service
public class ParcoNaturaleService {
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;
	
	@Autowired
	private AnimaleRepository animaleRepository;
	
	@Autowired
	private PiantaRepository piantaRepository;

	public List<ParcoNaturaleTO> getListParchi() {
		return parcoNaturaleRepository.findAllParchi();
	}

	public InfoParcoTO getInfoParco(Long idParco) {
		
		InfoParcoTO infoParcoTO = new InfoParcoTO(parcoNaturaleRepository.findParcoById(idParco), 
				animaleRepository.findAnimaleByIdParco(idParco),
				piantaRepository.findPiantaByIdParco(idParco));
		
		return infoParcoTO;
	}
}
