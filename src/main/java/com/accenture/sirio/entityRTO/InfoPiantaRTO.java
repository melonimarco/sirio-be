package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;

public class InfoPiantaRTO {
	
	private Long id;
	
	private TipoOrdineAppartenenzaPiantaTO tipoPianta;
	
	private String specie;

	public InfoPiantaRTO() {
		super();
	}

	public InfoPiantaRTO(Long id, String specie, Long tipoPiantaLong, String descrizioneTipoPianta) {
		super();
		
		TipoOrdineAppartenenzaPiantaTO tipoPiantaTO = new TipoOrdineAppartenenzaPiantaTO();
		
		this.id = id;
		this.specie = specie;
		
		tipoPiantaTO.setId(tipoPiantaLong);
		tipoPiantaTO.setDescrizione(descrizioneTipoPianta);
		this.tipoPianta = tipoPiantaTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoOrdineAppartenenzaPiantaTO getTipoPianta() {
		return tipoPianta;
	}

	public void setTipoPianta(TipoOrdineAppartenenzaPiantaTO tipoPianta) {
		this.tipoPianta = tipoPianta;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}	
	
}
