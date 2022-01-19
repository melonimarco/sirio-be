package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;

@Service
public class TipoEntitaInserimentoService {
	@Autowired
	private TipoEntitaInserimentoRepository tipoEntitaInserimentoRepository;

	public Iterable<TipoEntitaInserimentoTO> findAll() {
		// TODO Auto-generated method stub
		return tipoEntitaInserimentoRepository.findAllEntita();
	}
}
