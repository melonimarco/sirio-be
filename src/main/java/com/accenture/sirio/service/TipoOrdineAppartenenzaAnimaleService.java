package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaleRepository;

@Service
public class TipoOrdineAppartenenzaAnimaleService {
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaleRepository tipoOrdineAppartenenzaAnimaliRepository;
	
	public List<TipoOrdineAppartenenzaAnimaleTO> getListOrdAppAnimale(){
		return tipoOrdineAppartenenzaAnimaliRepository.findAllOrdiniAppAnimali();
	}
	
}
