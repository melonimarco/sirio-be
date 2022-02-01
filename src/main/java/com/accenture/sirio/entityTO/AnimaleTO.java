package com.accenture.sirio.entityTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AnimaleTO {
	
	@NotNull(message = "Specie cannot be null")
	private String specie;
	
	@NotNull(message = "Sesso cannot be null")
	private Character sesso;
	
	@NotNull(message = "Numero Esemplari cannot be null")
	@Min(value = 1, message = "Numero Esemplari should not be less than 1")
	private Integer numEsemplari;
	
	@NotNull(message = "Tipo Animale cannot be null")
	private Long tipoAnimale;
	
	@NotNull(message = "Stato Salute cannot be null")
	private Long tipoStatoSalute;
	
	@NotNull(message = "Parco cannot be null")
	private Long parco;
	
	public AnimaleTO() {
		super();
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

	public Integer getNumEsemplari() {
		return numEsemplari;
	}

	public void setNumEsemplari(Integer numEsemplari) {
		this.numEsemplari = numEsemplari;
	}

	public Long getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(Long tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}

	public Long getTipoStatoSalute() {
		return tipoStatoSalute;
	}

	public void setTipoStatoSalute(Long tipoStatoSalute) {
		this.tipoStatoSalute = tipoStatoSalute;
	}

	public Long getParco() {
		return parco;
	}

	public void setParco(Long parco) {
		this.parco = parco;
	}
	
}
