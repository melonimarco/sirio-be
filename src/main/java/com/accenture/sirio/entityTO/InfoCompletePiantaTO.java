package com.accenture.sirio.entityTO;

import javax.validation.constraints.NotNull;

public class InfoCompletePiantaTO {
	
	private Long id;
	
	@NotNull(message = "Specie cannot be null")
	private String specie;

	@NotNull(message = "Tipo Pianta cannot be null")
	private TipoOrdineAppartenenzaPiantaTO tipoPianta;

	@NotNull(message = "Stagione Fioritura cannot be null")
	private TipoStagioneFiorituraTO StagioneFioritura;

	@NotNull(message = "Parco cannot be null")
	private ParcoNaturaleTO parco;

	public InfoCompletePiantaTO() {
		super();
	}

	public InfoCompletePiantaTO(Long id, @NotNull(message = "Specie cannot be null") String specie,
			@NotNull(message = "Tipo Pianta cannot be null") TipoOrdineAppartenenzaPiantaTO tipoPianta,
			@NotNull(message = "Stagione Fioritura cannot be null") TipoStagioneFiorituraTO stagioneFioritura,
			@NotNull(message = "Parco cannot be null") ParcoNaturaleTO parco) {
		super();
		this.id = id;
		this.specie = specie;
		this.tipoPianta = tipoPianta;
		StagioneFioritura = stagioneFioritura;
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

	public TipoOrdineAppartenenzaPiantaTO getTipoPianta() {
		return tipoPianta;
	}

	public void setTipoPianta(TipoOrdineAppartenenzaPiantaTO tipoPianta) {
		this.tipoPianta = tipoPianta;
	}

	public TipoStagioneFiorituraTO getStagioneFioritura() {
		return StagioneFioritura;
	}

	public void setStagioneFioritura(TipoStagioneFiorituraTO stagioneFioritura) {
		StagioneFioritura = stagioneFioritura;
	}

	public ParcoNaturaleTO getParco() {
		return parco;
	}

	public void setParco(ParcoNaturaleTO parco) {
		this.parco = parco;
	}

	
}
