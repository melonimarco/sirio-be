package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.repository.PianteRepository;

@Service
public class PianteService {
	@Autowired
	private PianteRepository pianteRepository;
}
