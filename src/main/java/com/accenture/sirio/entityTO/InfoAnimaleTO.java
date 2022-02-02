package com.accenture.sirio.entityTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InfoAnimaleTO {
	
	private Long id;
	
	@NotNull(message = "Tipo Animale cannot be null")
	private TipoOrdineAppartenenzaAnimaleTO tipoAnimale;
	
	@NotNull(message = "Specie cannot be null")
	private String specie;
	
	@NotNull(message = "Sesso cannot be null")
	private Character sesso;
	
	public InfoAnimaleTO() {
		super();
	}
	
	public InfoAnimaleTO(Long id,
			@NotNull(message = "Tipo Animale cannot be null") TipoOrdineAppartenenzaAnimaleTO tipoAnimale,
			@NotNull(message = "Specie cannot be null") String specie,
			@NotNull(message = "Sesso cannot be null") Character sesso
			) {
		super();
		this.id = id;
		this.tipoAnimale = tipoAnimale;
		this.specie = specie;
		this.sesso = sesso;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoOrdineAppartenenzaAnimaleTO getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(TipoOrdineAppartenenzaAnimaleTO tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}
	
	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

}
