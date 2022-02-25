package com.accenture.sirio.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.RegioneTO;
import com.accenture.sirio.service.RegioneService;

@Service
public class RegioneFacade {
	
	@Autowired
	private RegioneService regioneService;
	
	public List<RegioneTO> getListRegioni(){
		return regioneService.getListRegioni();
	}
}
