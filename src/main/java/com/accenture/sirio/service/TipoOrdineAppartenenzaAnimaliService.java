package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaleRepository;

@Service
public class TipoOrdineAppartenenzaAnimaliService {
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaleRepository tipoOrdineAppartenenzaAnimaliRepository;
}
