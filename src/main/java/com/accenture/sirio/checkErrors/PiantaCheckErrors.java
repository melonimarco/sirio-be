package com.accenture.sirio.checkErrors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.service.PiantaService;

@Service
public class PiantaCheckErrors extends BaseCheckErrors{
	@Autowired
	private PiantaService piantaService;
	
	public List<String> checkIdExist(Long idPianta) {
		List<String> messaggiList = new ArrayList<>();
		
		if(idPianta!=null) {
			if(!piantaService.checkIfPiantaExist(idPianta)) {
				messaggiList.add("La pianta non è stata trovata");
			}
		} else {
			messaggiList.add("L'id non può essere null");
		}
		
		return messaggiList;
	}
	
	public List<String> checkSpecieAlreadyExist(PiantaTO piantaTO){
		List<String> messaggiList = new ArrayList<>();
		
		if(piantaService.checkSpecieAlreadyExist(piantaTO)) {
			messaggiList.add("La specie è già stata inserita");
		}
		
		return messaggiList;
	}
	
	public List<String> checkIfPiantaExist(PiantaTO piantaTO, Long idPianta) {
		
		List<String> messaggiList = new ArrayList<>();

		if(piantaService.checkSpecieAlreadyExistEdit(piantaTO, idPianta)) {
			messaggiList.add("La specie è già stata inserita");
		} 
			
		return messaggiList;
		
	}
	
	public List<String> editPiantaCheck(PiantaTO piantaTO, Long idPianta) {
		
		List<String> messaggiList = new ArrayList<>();
		
		messaggiList.addAll(checkIdExist(idPianta));
		
		if(messaggiList.isEmpty()) {
			messaggiList.addAll(checkIfPiantaExist(piantaTO, idPianta));
		} 
			
		return messaggiList;
		
	}

	
	
}
