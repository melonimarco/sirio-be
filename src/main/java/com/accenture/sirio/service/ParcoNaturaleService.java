package com.accenture.sirio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InfoAnimaleTO;
import com.accenture.sirio.entityTO.InfoParcoTO;
import com.accenture.sirio.entityTO.InfoPiantaTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.PiantaTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.repository.AnimaleRepository;
import com.accenture.sirio.repository.ParcoNaturaleRepository;
import com.accenture.sirio.repository.PiantaRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaAnimaleRepository;
import com.accenture.sirio.repository.TipoOrdineAppartenenzaPiantaRepository;

@Service
public class ParcoNaturaleService {
	@Autowired
	private ParcoNaturaleRepository parcoNaturaleRepository;
	
	@Autowired
	private AnimaleRepository animaleRepository;
	
	@Autowired
	private PiantaRepository piantaRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaAnimaleRepository tipoOrdineAppartenenzaAnimaleRepository;
	
	@Autowired
	private TipoOrdineAppartenenzaPiantaRepository tipoOrdineAppartenenzaPiantaRepository;

	public List<ParcoNaturaleTO> getListParchi() {
		return parcoNaturaleRepository.findAllParchi();
	}

	public InfoParcoTO getInfoParco(Long idParco) {
		
		List<InfoAnimaleTO> InfoAnimaleList = populateListInfoAnimale(animaleRepository.findAnimaleByIdParco(idParco));
		List<InfoPiantaTO> InfoPiantaList = populateListInfoPianta(piantaRepository.findPiantaByIdParco(idParco));
		
		InfoParcoTO infoParcoTO = new InfoParcoTO(parcoNaturaleRepository.findParcoById(idParco), 
				InfoAnimaleList,
				InfoPiantaList);
		
		return infoParcoTO;
	}
	
	private List<InfoAnimaleTO> populateListInfoAnimale(List<AnimaleTO> listAnimali) {
		
		List<TipoOrdineAppartenenzaAnimaleTO> ListOrdAppAnimale = tipoOrdineAppartenenzaAnimaleRepository.findAllOrdiniAppAnimali();
		List<InfoAnimaleTO> listInfoAnimali = new ArrayList<>();
		
		for(AnimaleTO animale : listAnimali) {
			InfoAnimaleTO infoAnimaleTO = new InfoAnimaleTO();
			infoAnimaleTO.setId(animale.getId());
			infoAnimaleTO.setSpecie(animale.getSpecie());
			infoAnimaleTO.setSesso(animale.getSesso());
			
			for(TipoOrdineAppartenenzaAnimaleTO ordAppAnimale : ListOrdAppAnimale) {
				if(ordAppAnimale.getId()==animale.getTipoAnimale()) {
					infoAnimaleTO.setTipoAnimale(ordAppAnimale);
				}
			}
			
			listInfoAnimali.add(infoAnimaleTO);
		}
		
		return listInfoAnimali;
	}
	
	private List<InfoPiantaTO> populateListInfoPianta(List<PiantaTO> listPiante) {
		
		List<TipoOrdineAppartenenzaPiantaTO> ListOrdAppPianta = tipoOrdineAppartenenzaPiantaRepository.findAllOrdiniAppPiante();
		List<InfoPiantaTO> listInfoPiante = new ArrayList<>();
		
		for(PiantaTO pianta : listPiante) {
			InfoPiantaTO infoPiantaTO = new InfoPiantaTO();
			
			infoPiantaTO.setId(pianta.getId());
			infoPiantaTO.setSpecie(pianta.getSpecie());
			
			for(TipoOrdineAppartenenzaPiantaTO ordAppPianta : ListOrdAppPianta) {
				if(ordAppPianta.getId()==pianta.getTipoPianta()) {
					infoPiantaTO.setTipoPianta(ordAppPianta);
				}
			}
			
			listInfoPiante.add(infoPiantaTO);
			
		}
		
		return listInfoPiante;
	}
	
}
