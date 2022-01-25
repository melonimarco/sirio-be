package com.accenture.sirio.entityTO;

import javax.validation.constraints.NotNull;

public class PiantaTO {
	
	@NotNull(message = "Specie cannot be null")
	private String specie;

	@NotNull(message = "Tipo Pianta cannot be null")
	private Long tipoPianta;

	@NotNull(message = "Stagione Fioritura cannot be null")
	private Long StagioneFioritura;

	@NotNull(message = "Parco cannot be null")
	private Long parco;

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public Long getTipoPianta() {
		return tipoPianta;
	}

	public void setTipoPianta(Long tipoPianta) {
		this.tipoPianta = tipoPianta;
	}

	public Long getStagioneFioritura() {
		return StagioneFioritura;
	}

	public void setStagioneFioritura(Long stagioneFioritura) {
		StagioneFioritura = stagioneFioritura;
	}

	public Long getParco() {
		return parco;
	}

	public void setParco(Long parco) {
		this.parco = parco;
	}

	

	
	
	
}
