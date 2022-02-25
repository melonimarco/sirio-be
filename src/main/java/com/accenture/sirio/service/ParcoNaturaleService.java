package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.ParcoNaturale;
import com.accenture.sirio.entityRTO.XlsInfoParchiRTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.ParcoSalvataggioTO;
import com.accenture.sirio.repository.ParcoNaturaleRepository;


@Service
public class ParcoNaturaleService {
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;


	public List<ParcoNaturaleTO> getListParchi() {
		return parcoNaturaleRepository.findAllParchi();
	}

	public ParcoNaturaleTO getParcoById(Long idParco) {
		return parcoNaturaleRepository.findParcoById(idParco);
	}
	
	public List<XlsInfoParchiRTO> getInfoParchiAnimaliXls() {
		return parcoNaturaleRepository.findInfoParchiAnimaliXls();
	}
	
	public List<XlsInfoParchiRTO> getInfoParchiPianteXls() {
		return parcoNaturaleRepository.findInfoParchiPianteXls();
	}

	public Long saveParco(ParcoSalvataggioTO parcoSalvataggioTO) {
		
		ParcoNaturale save = parcoNaturaleRepository.save(convertToParco(parcoSalvataggioTO));
		
		return save.getId();
	}
	
	public ParcoNaturale convertToParco(ParcoSalvataggioTO parcoSalvataggioTO) {
		
		ParcoNaturale parcoNaturale = new ParcoNaturale();
		
		parcoNaturale.setNome(parcoSalvataggioTO.getNome());
		parcoNaturale.setRegione(parcoSalvataggioTO.getRegione());
		
		return parcoNaturale;
	}

	public String getParcoByNome(String nomeParco) {
		return parcoNaturaleRepository.findParcoByNome(nomeParco);
		
	}
	
}
