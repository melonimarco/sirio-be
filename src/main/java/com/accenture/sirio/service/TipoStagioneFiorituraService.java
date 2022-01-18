package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.TipoStagioneFioritura;
import com.accenture.sirio.repository.TipoStagioneFiorituraRepository;

@Service
public class TipoStagioneFiorituraService {
	@Autowired
	private TipoStagioneFiorituraRepository tipoStagioneFiorituraRepository;
}
