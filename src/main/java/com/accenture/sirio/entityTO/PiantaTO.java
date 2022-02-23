package com.accenture.sirio.entityTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PiantaTO {
	
	private Long id;
	
	@NotNull(message = "Specie cannot be null")
	@NotBlank(message = "Specie cannot be null")
	private String specie;

	@NotNull(message = "Tipo Pianta cannot be null")
	private Long tipoPianta;

	@NotNull(message = "Stagione Fioritura cannot be null")
	private Long StagioneFioritura;

	@NotNull(message = "Parco cannot be null")
	private Long parco;

	public PiantaTO() {
		super();
	}

	

	public PiantaTO(Long id,
			@NotNull(message = "Specie cannot be null") @NotBlank(message = "Specie cannot be null") String specie,
			@NotNull(message = "Tipo Pianta cannot be null") Long tipoPianta,
			@NotNull(message = "Stagione Fioritura cannot be null") Long stagioneFioritura,
			@NotNull(message = "Parco cannot be null") Long parco) {
		super();
		this.id = id;
		this.specie = specie;
		this.tipoPianta = tipoPianta;
		this.StagioneFioritura = stagioneFioritura;
		this.parco = parco;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	@Override
	public String toString() {
		return "PiantaTO [id=" + id + ", specie=" + specie + ", tipoPianta=" + tipoPianta + ", StagioneFioritura="
				+ StagioneFioritura + ", parco=" + parco + "]";
	}

	

	
	
	
}
