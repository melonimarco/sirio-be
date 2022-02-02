package com.accenture.sirio.entityTO;

import javax.validation.constraints.NotNull;

public class InfoPiantaTO {
	
	private Long id;
	
	@NotNull(message = "Tipo Pianta cannot be null")
	private TipoOrdineAppartenenzaPiantaTO tipoPianta;
	
	@NotNull(message = "Specie cannot be null")
	private String specie;

	public InfoPiantaTO() {
		super();
	}

	public InfoPiantaTO(Long id,
			@NotNull(message = "Tipo Pianta cannot be null") TipoOrdineAppartenenzaPiantaTO tipoPianta,
			@NotNull(message = "Specie cannot be null") String specie){
		super();
		this.id = id;
		this.tipoPianta = tipoPianta;
		this.specie = specie;
	
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
