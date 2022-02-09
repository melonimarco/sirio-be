package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;
import com.accenture.sirio.repository.TipoStagioneFiorituraRepository;

@Service
public class TipoStagioneFiorituraService {
	@Autowired
	private TipoStagioneFiorituraRepository tipoStagioneFiorituraRepository;
	
	public List<TipoStagioneFiorituraTO> getListStagioniFioritura() {
		return tipoStagioneFiorituraRepository.findAllStagioni();
	}
}
