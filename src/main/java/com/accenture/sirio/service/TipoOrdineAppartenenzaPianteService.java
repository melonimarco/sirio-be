package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.TipoOrdineAppartenenzaPianta;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaPiantaRepository;

@Service
public class TipoOrdineAppartenenzaPianteService {
	@Autowired
	private TipoOrdineAppartenenzaPiantaRepository tipoOrdineAppartenenzaPianteRepository;
}
