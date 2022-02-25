package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.ListRegioniTO;
import com.accenture.sirio.entityTO.RegioneTO;
import com.accenture.sirio.repository.RegioneRepository;

@Service
public class RegioneService {
	@Autowired
	private RegioneRepository regioneRepository;

	public List<RegioneTO> getListRegioni() {
		return regioneRepository.findAllRegioni();
	}
}
