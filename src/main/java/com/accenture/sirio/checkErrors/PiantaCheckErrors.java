package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.controller.PiantaController;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.service.PiantaService;

@Service
public class PiantaCheckErrors extends BaseCheckErrors{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PiantaCheckErrors.class);
	
	@Autowired
	private PiantaService piantaService;
	
	//Controllo che l'id non sia null e che sia presente a DB
	public List<String> checkIdExist(Long idPianta) {
		LOGGER.info("Controlli campo id");
		List<String> messaggiList = new ArrayList<>();
		
		LOGGER.info("Controllo se l'id è null");
		if(idPianta!=null) {
			LOGGER.info("id valorizzato");
			
			if(!piantaService.checkIfPiantaExist(idPianta)) {
				LOGGER.info("Controllo se l'id è presente a DB");
				messaggiList.add("La pianta non è stata trovata");
			}
		} else {
			LOGGER.error("id null");
			messaggiList.add("L'id non può essere null");
		}
		
		return messaggiList;
	}
	
	//Controllo se quella specie è già presente controllando specie e parco
	public List<String> checkSpecieAlreadyExist(PiantaTO piantaTO){
		LOGGER.info("Controllo se la specie è già presente nel parco");
		List<String> messaggiList = new ArrayList<>();
		
		if(piantaService.checkSpecieAlreadyExist(piantaTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		
		return messaggiList;
	}
	
	//Controllo se quella specie è già presente controllando id, specie, sesso e parco
	public List<String> checkSpecieAlreadyExistEdit(PiantaTO piantaTO, Long idPianta) {
		LOGGER.info("Controllo se una specie con id diverso è già presente nel parco");
		List<String> messaggiList = new ArrayList<>();

		if(piantaService.checkSpecieAlreadyExistEdit(piantaTO, idPianta)) {
			messaggiList.add("La specie è già stata inserita");
		} 
			
		return messaggiList;
		
	}
	
	//controllo che i valori arrivino maggiori di 1
	public List<String> checkValoreSelect(Long valore, String messaggio) {
		LOGGER.info("Controllo se i valori inseriti sono maggiori di 1");
		List<String> messaggiList = new ArrayList<>();
		
		if(valore<1) {
			messaggiList.add(messaggio);
		} 
		return messaggiList;
		
	}
	
	// --- Controlli congiunti ---
	
	//Controlli per l'edit di una pianta
	public List<String> editPiantaCheck(PiantaTO piantaTO, Long idPianta) {
		LOGGER.info("Controllo i campi inseriti in input per edit");
		List<String> messaggiList = new ArrayList<>();
		
		messaggiList.addAll(checkIdExist(idPianta));
		
		if(messaggiList.isEmpty()) {
			messaggiList.addAll(checkSpecieAlreadyExistEdit(piantaTO, idPianta));
			messaggiList.addAll(checkValoreSelect(piantaTO.getParco(), "Inserire un parco"));
			messaggiList.addAll(checkValoreSelect(piantaTO.getTipoPianta(), "Inserire un tipo pianta"));
			messaggiList.addAll(checkValoreSelect(piantaTO.getStagioneFioritura(), "Inserire una stagione fioritura"));
		} 
		
		LOGGER.info("Fine controlli per edit");
		return messaggiList;
		
	}

	
	
}
