package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class TipoEntitaInserimentoService {
	@Autowired
	private TipoEntitaInserimentoRepository tipoEntitaInserimentoRepository;

	public List<TipoEntitaInserimentoTO> getListEntitaInserimento() {
		
		return tipoEntitaInserimentoRepository.findAllEntita();
	}
}
