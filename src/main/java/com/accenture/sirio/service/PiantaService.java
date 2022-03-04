package com.accenture.sirio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entity.Pianta;
import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityRTO.InfoPiantaRTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.repository.PiantaRepository;

@Service
public class PiantaService {
	@Autowired
	private PiantaRepository piantaRepository;

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

	public InfoCompletePiantaRTO getPianta(Long idPianta) {
	
		return piantaRepository.findInfoCompletePiantaById(idPianta);
	}

	//-----Gestione Update Pianta-----
	
	public boolean checkSpecieAlreadyExistEdit(PiantaTO piantaTO, Long idPianta) {
		return piantaRepository.findSpecieEdit(idPianta, piantaTO.getSpecie(), piantaTO.getParco())!=null;
	}

	public Long editPianta(PiantaTO piantaTO, Long idPianta) {
		
		Pianta pianta = piantaRepository.getById(idPianta);
		
		Pianta save = piantaRepository.save(convertToPiantaEdit(pianta, piantaTO));
		return save.getId();
	}

	private Pianta convertToPiantaEdit(Pianta pianta, PiantaTO piantaTO) {
		
		pianta.setSpecie(piantaTO.getSpecie());
		pianta.setTipoOrdineAppartenenzaPiante(piantaTO.getTipoPianta());
		pianta.setTipoStagioneFioritura(piantaTO.getStagioneFioritura());
		pianta.setParcoNaturale(piantaTO.getParco());
		
		return pianta;
	}
	
	//-----Fine Gestione Update Pianta-----
	
	public Long deletePianta(Long idPianta) {
		
		piantaRepository.deleteById(idPianta);
		
		return idPianta;
	}

	public boolean checkIfPiantaExist(Long idPianta) {
		return piantaRepository.findPiantaById(idPianta)!=null;
	}

}
