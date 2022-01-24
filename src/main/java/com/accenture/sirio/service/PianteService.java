package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.Animali;
import com.accenture.sirio.entity.Piante;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.PianteRepository;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaPianteRepository;
import com.accenture.sirio.repository.TipoStagioneFiorituraRepository;

@Service
public class PianteService {
	@Autowired
	private PianteRepository pianteRepository;
	
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaPianteRepository tipoOrdineAppartenenzaPianteRepository;
	
	@Autowired
	private TipoStagioneFiorituraRepository tipoStagioneFiorituraRepository;
	
	@Autowired
	private TipoEntitaInserimentoRepository tipoEntitaInserimentoRepository;

	public InitPiantaTO initCreazione() {
		
		InitPiantaTO initPiantaTO = new InitPiantaTO(tipoEntitaInserimentoRepository.findAllEntita(),
				tipoStagioneFiorituraRepository.findAllStagioni(),
				tipoOrdineAppartenenzaPianteRepository.findAllOrdiniAppPiante(),
				parcoNaturaleRepository.findAllParchi());
		
		return initPiantaTO;
	}

	public Long savePianta(PiantaTO piantaTO) {
		
		Piante pianta = new Piante(piantaTO);
		Piante save = pianteRepository.save(pianta);
		return save.getId();
	}

	public void checkSpecieAlreadyExist(String specie, String messaggio) throws SpecieAlreadyExistException {
		
		String specieFound = pianteRepository.findSpecie(specie);
		
		if(specieFound!=null && !specieFound.isEmpty() && specieFound.equalsIgnoreCase(specie)) {
			throw new SpecieAlreadyExistException(messaggio);
		}
		
	}
}
