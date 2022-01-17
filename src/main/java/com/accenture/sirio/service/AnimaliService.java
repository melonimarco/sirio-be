package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.repository.AnimaliRepository;

@Service
public class AnimaliService {

	@Autowired
	private AnimaliRepository animaliRepository;
}
