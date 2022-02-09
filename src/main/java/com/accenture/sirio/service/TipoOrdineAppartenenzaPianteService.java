package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaPiantaRepository;

@Service
public class TipoOrdineAppartenenzaPianteService {
	@Autowired
	private TipoOrdineAppartenenzaPiantaRepository tipoOrdineAppartenenzaPianteRepository;
	
	public List<TipoOrdineAppartenenzaPiantaTO> getListOrdAppPiante(){
		return tipoOrdineAppartenenzaPianteRepository.findAllOrdiniAppPiante();
	}
}
