package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoStatoSaluteTO;
import com.accenture.sirio.repository.TipoStatoSaluteRepository;

@Service
public class TipoStatoSaluteService {
	@Autowired
	private TipoStatoSaluteRepository tipoStatoSaluteRepository;
	
	public List<TipoStatoSaluteTO> getListStatiSalute(){
		return tipoStatoSaluteRepository.findAllStatiSalute();
	}
}
