package com.accenture.sirio.entityTO;

public class InfoCompletePiantaTO {
	
	private Long id;
	
	private String specie;

	private TipoOrdineAppartenenzaPiantaTO tipoPianta;
	
	private Long tipoPiantaLong;
	
	private String descrizioneTipoPianta;

	private TipoStagioneFiorituraTO stagioneFioritura;
	
	private Long stagioneFiorituraLong;
	
	private String descrizioneStagioneFioritura;

	private ParcoNaturaleTO parco;
	
	private Long parcoLong;
	
	private String descrizioneParco;

	public InfoCompletePiantaTO() {
		super();
	}
	
	

	public InfoCompletePiantaTO(Long id, String specie, Long tipoPiantaLong, 
			Long stagioneFiorituraLong, Long parcoLong, String descrizioneTipoPianta, 
			String descrizioneStagioneFioritura, String descrizioneParco) {
		super();
		
		TipoOrdineAppartenenzaPiantaTO tipoOrdineAppartenenzaPiantaTO = new TipoOrdineAppartenenzaPiantaTO();
		
		TipoStagioneFiorituraTO tipoStagioneFiorituraTO = new TipoStagioneFiorituraTO();
		
		ParcoNaturaleTO parcoNaturaleTO = new ParcoNaturaleTO();
		
		this.id = id;
		this.specie = specie;
		this.tipoPiantaLong = tipoPiantaLong;
		this.descrizioneTipoPianta = descrizioneTipoPianta;
		this.stagioneFiorituraLong = stagioneFiorituraLong;
		this.descrizioneStagioneFioritura = descrizioneStagioneFioritura;
		this.parcoLong = parcoLong;
		this.descrizioneParco = descrizioneParco;
		
		tipoOrdineAppartenenzaPiantaTO.setId(tipoPiantaLong);
		tipoOrdineAppartenenzaPiantaTO.setDescrizione(descrizioneTipoPianta);
		this.tipoPianta = tipoOrdineAppartenenzaPiantaTO;
		
		tipoStagioneFiorituraTO.setId(stagioneFiorituraLong);
		tipoStagioneFiorituraTO.setDescrizione(descrizioneStagioneFioritura);
		this.stagioneFioritura = tipoStagioneFiorituraTO;
		
		parcoNaturaleTO.setId(parcoLong);
		parcoNaturaleTO.setNome(descrizioneParco);
		this.parco = parcoNaturaleTO;
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

	public Long getTipoPiantaLong() {
		return tipoPiantaLong;
	}

	public void setTipoPiantaLong(Long tipoPiantaLong) {
		this.tipoPiantaLong = tipoPiantaLong;
	}

	public String getDescrizioneTipoPianta() {
		return descrizioneTipoPianta;
	}

	public void setDescrizioneTipoPianta(String descrizioneTipoPianta) {
		this.descrizioneTipoPianta = descrizioneTipoPianta;
	}

	public TipoStagioneFiorituraTO getStagioneFioritura() {
		return stagioneFioritura;
	}

	public void setStagioneFioritura(TipoStagioneFiorituraTO stagioneFioritura) {
		this.stagioneFioritura = stagioneFioritura;
	}

	public Long getStagioneFiorituraLong() {
		return stagioneFiorituraLong;
	}

	public void setStagioneFiorituraLong(Long stagioneFiorituraLong) {
		this.stagioneFiorituraLong = stagioneFiorituraLong;
	}

	public String getDescrizioneStagioneFioritura() {
		return descrizioneStagioneFioritura;
	}

	public void setDescrizioneStagioneFioritura(String descrizioneStagioneFioritura) {
		this.descrizioneStagioneFioritura = descrizioneStagioneFioritura;
	}

	public ParcoNaturaleTO getParco() {
		return parco;
	}

	public void setParco(ParcoNaturaleTO parco) {
		this.parco = parco;
	}

	public Long getParcoLong() {
		return parcoLong;
	}

	public void setParcoLong(Long parcoLong) {
		this.parcoLong = parcoLong;
	}

	public String getDescrizioneParco() {
		return descrizioneParco;
	}

	public void setDescrizioneParco(String descrizioneParco) {
		this.descrizioneParco = descrizioneParco;
	}
	
	
	
}
