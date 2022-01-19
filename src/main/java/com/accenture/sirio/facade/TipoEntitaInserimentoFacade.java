package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.TipoEntitaInserimento;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.service.TipoEntitaInserimentoService;

@Service
public class TipoEntitaInserimentoFacade {
	@Autowired
	private TipoEntitaInserimentoService tipoEntitaInserimentoService;

	public Iterable<TipoEntitaInserimentoTO> findAll() {
		// TODO Auto-generated method stub
		return tipoEntitaInserimentoService.findAll();
	}
}
