package com.accenture.sirio.facade;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityRTO.InitEditPiantaRTO;
import com.accenture.sirio.entityTO.InitPiantaTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;
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
	private TipoEntitaInserimentoService tipoEntitaInserimentoService;
	
	@Autowired 
	private TipoStagioneFiorituraService tipoStagioneFiorituraService;
	
	@Autowired
	private TipoOrdineAppartenenzaPianteService tipoOrdineAppartenenzaPianteService;
	
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;

	public InitPiantaTO initCreazione() {
		
		List<TipoEntitaInserimentoTO> listEntitaInserimento = tipoEntitaInserimentoService.getListEntitaInserimento();
		List<TipoStagioneFiorituraTO> listStagioniFioritura = tipoStagioneFiorituraService.getListStagioniFioritura();
		List<TipoOrdineAppartenenzaPiantaTO> listOrdAppPiante = tipoOrdineAppartenenzaPianteService.getListOrdAppPiante();
		List<ParcoNaturaleTO> listParchi = parcoNaturaleService.getListParchi();
		
		InitPiantaTO initPiantaTO = new InitPiantaTO(listEntitaInserimento, listStagioniFioritura,
				listOrdAppPiante, listParchi);
		
		return initPiantaTO;
	}

	@Transactional
	public Long savePianta(PiantaTO piantaTO) {
		
		return piantaService.savePianta(piantaTO);
	}

	//Dettaglio pianta
	public InfoCompletePiantaRTO getPianta(Long idPianta) {
		return piantaService.getPianta(idPianta);
	}

	public InitEditPiantaRTO initEditPianta(Long idPianta) {
		
		InitPiantaTO initPiantaRTO = initCreazione();
		InfoCompletePiantaRTO pianta = getPianta(idPianta);

		InitEditPiantaRTO initEditPiantaRTO = new InitEditPiantaRTO(initPiantaRTO, pianta);
		
		return initEditPiantaRTO;
	}
	
	@Transactional
	public Long editPianta(PiantaTO piantaTO, Long idPianta) {
		return piantaService.editPianta(piantaTO, idPianta);
	}

	@Transactional
	public Long deletePianta(Long idPianta) {
		return piantaService.deletePianta(idPianta);
	}

	
	
	
}
