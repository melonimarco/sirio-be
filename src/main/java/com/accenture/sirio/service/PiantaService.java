package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entity.Pianta;
import com.accenture.sirio.entityRTO.InfoPiantaRTO;
import com.accenture.sirio.entityTO.InfoCompletePiantaTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;
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
	private PiantaRepository piantaRepository;
	
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
		
		Pianta save = piantaRepository.save(convertToPianta(piantaTO));
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
		
		return piantaRepository.findSpecie(piantaTO.getSpecie(), piantaTO.getParco())!=null;

	}
	
	public List<InfoPiantaRTO> getListInfoPiantaTOByIdParco(Long idParco){
		return piantaRepository.findInfoPiantaByIdParco(idParco);
	}

	public InfoCompletePiantaTO getPianta(Long idPianta) {
		
		PiantaTO piantaTO = piantaRepository.findPiantaById(idPianta);
		
		TipoOrdineAppartenenzaPiantaTO tipoPianta = tipoOrdineAppartenenzaPianteRepository.findOrdineAppPianteById(piantaTO.getTipoPianta());	
		TipoStagioneFiorituraTO Stagionefioritura = tipoStagioneFiorituraRepository.findStagioneById(piantaTO.getStagioneFioritura());
		ParcoNaturaleTO parco = parcoNaturaleRepository.findParcoById(piantaTO.getParco());
		
		InfoCompletePiantaTO infoCompletePiantaTO = new InfoCompletePiantaTO();
		
		infoCompletePiantaTO.setId(piantaTO.getId());
		infoCompletePiantaTO.setSpecie(piantaTO.getSpecie());
		infoCompletePiantaTO.setTipoPianta(tipoPianta);
		infoCompletePiantaTO.setStagioneFioritura(Stagionefioritura);
		infoCompletePiantaTO.setParco(parco);
		
		return infoCompletePiantaTO;
	}
}
