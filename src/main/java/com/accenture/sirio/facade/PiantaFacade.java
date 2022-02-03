package com.accenture.sirio.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
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
	
	
}
