package com.accenture.sirio.entityTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InfoCompleteAnimaleTO {
	
	private Long id;
	
	@NotNull(message = "Tipo Animale cannot be null")
	private TipoOrdineAppartenenzaAnimaleTO tipoAnimale;
	
	@NotNull(message = "Specie cannot be null")
	private String specie;
	
	@NotNull(message = "Sesso cannot be null")
	private Character sesso;
	
	@NotNull(message = "Parco cannot be null")
	private ParcoNaturaleTO parco;
	
	@NotNull(message = "Stato Salute cannot be null")
	private TipoStatoSaluteTO tipoStatoSalute;
	
	@NotNull(message = "Numero Esemplari cannot be null")
	@Min(value = 1, message = "Numero Esemplari should not be less than 1")
	private Integer numEsemplari;
	
	
	public InfoCompleteAnimaleTO() {
		super();
	}


	public InfoCompleteAnimaleTO(Long id,
			@NotNull(message = "Tipo Animale cannot be null") TipoOrdineAppartenenzaAnimaleTO tipoAnimale,
			@NotNull(message = "Specie cannot be null") String specie,
			@NotNull(message = "Sesso cannot be null") Character sesso,
			@NotNull(message = "Parco cannot be null") ParcoNaturaleTO parco,
			@NotNull(message = "Stato Salute cannot be null") TipoStatoSaluteTO tipoStatoSalute,
			@NotNull(message = "Numero Esemplari cannot be null") @Min(value = 1, message = "Numero Esemplari should not be less than 1") Integer numEsemplari) {
		super();
		this.id = id;
		this.tipoAnimale = tipoAnimale;
		this.specie = specie;
		this.sesso = sesso;
		this.parco = parco;
		this.tipoStatoSalute = tipoStatoSalute;
		this.numEsemplari = numEsemplari;
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


	public ParcoNaturaleTO getParco() {
		return parco;
	}


	public void setParco(ParcoNaturaleTO parco) {
		this.parco = parco;
	}


	public TipoStatoSaluteTO getTipoStatoSalute() {
		return tipoStatoSalute;
	}


	public void setTipoStatoSalute(TipoStatoSaluteTO tipoStatoSalute) {
		this.tipoStatoSalute = tipoStatoSalute;
	}


	public Integer getNumEsemplari() {
		return numEsemplari;
	}


	public void setNumEsemplari(Integer numEsemplari) {
		this.numEsemplari = numEsemplari;
	}
	
	
}
