package com.accenture.sirio.facade;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityRTO.InitCreazionePiantaRTO;
import com.accenture.sirio.entityRTO.InitEditPiantaRTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.service.ParcoNaturaleService;
import com.accenture.sirio.service.PiantaService;
import com.accenture.sirio.service.TipoEntitaInserimentoService;
import com.accenture.sirio.service.TipoOrdineAppartenenzaPianteService;
import com.accenture.sirio.service.TipoStagioneFiorituraService;

@Service
public class PiantaFacade {
	@Autowired
	private PiantaService piantaService;
	
	@Autowired
	TipoEntitaInserimentoService tipoEntitaInserimentoService;
	
	@Autowired 
	TipoStagioneFiorituraService tipoStagioneFiorituraService;
	
	@Autowired
	TipoOrdineAppartenenzaPianteService tipoOrdineAppartenenzaPianteService;
	
	@Autowired
	ParcoNaturaleService parcoNaturaleService;

	public InitPiantaTO initCreazione() {
		
		InitPiantaTO initPiantaTO = new InitPiantaTO(tipoEntitaInserimentoService.getListEntitaInserimento(),
				tipoStagioneFiorituraService.getListStagioniFioritura(),
				tipoOrdineAppartenenzaPianteService.getListOrdAppPiante(),
				parcoNaturaleService.getListParchi());
		
		return initPiantaTO;
	}

	public Object savePianta(PiantaTO piantaTO) {
		
		return piantaService.savePianta(piantaTO);
	}

	public InfoCompletePiantaRTO getPianta(Long idPianta) {
		return piantaService.getPianta(idPianta);
	}

	public InitEditPiantaRTO initEditPianta(Long idPianta) {
		
		InitCreazionePiantaRTO initCreazionePiantaRTO = new InitCreazionePiantaRTO(tipoEntitaInserimentoService.getListEntitaInserimento(),
				tipoStagioneFiorituraService.getListStagioniFioritura(),
				tipoOrdineAppartenenzaPianteService.getListOrdAppPiante(),
				parcoNaturaleService.getListParchi(), piantaService.getPianta(idPianta));
		
		InitEditPiantaRTO initEditPiantaRTO = new InitEditPiantaRTO(initCreazionePiantaRTO);
		
		return initEditPiantaRTO;
	}
	
	@Transactional
	public Long editPianta(PiantaTO piantaTO, Long idPianta) {
		return piantaService.editPianta(piantaTO, idPianta);
	}

	
	
	
}
