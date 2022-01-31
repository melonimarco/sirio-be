package com.accenture.sirio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entity.Pianta;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.exceptions.SpecieAlreadyExistException;
import com.accenture.sirio.facade.PiantaFacade;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.PiantaRepository;
import com.accenture.sirio.repository.TipoEntitaInserimentoRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaPiantaRepository;
import com.accenture.sirio.repository.TipoStagioneFiorituraRepository;

@Service
public class PiantaService {
	@Autowired
	private PiantaRepository pianteRepository;
	
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaPiantaRepository tipoOrdineAppartenenzaPianteRepository;
	
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
		
		Pianta save = pianteRepository.save(convertToPianta(piantaTO));
		return save.getId();
	}
	
	public Pianta convertToPianta(PiantaTO piantaTO) {
		
		Pianta pianta = new Pianta();
		
		pianta.setSpecie(piantaTO.getSpecie());
		pianta.setTipoOrdineAppartenenzaPiante(piantaTO.getTipoPianta());
		pianta.setTipoStagioneFioritura(piantaTO.getStagioneFioritura());
		pianta.setParcoNaturale(piantaTO.getParco());
		return pianta;
	}

	public Boolean checkSpecieAlreadyExist(PiantaTO piantaTO) {
		
		return pianteRepository.findSpecie(piantaTO.getSpecie(), piantaTO.getParco())!=null;

	}
}
