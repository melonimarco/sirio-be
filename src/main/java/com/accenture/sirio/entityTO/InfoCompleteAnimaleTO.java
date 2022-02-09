package com.accenture.sirio.entityTO;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;

public class InfoCompleteAnimaleTO {
	
	private Long id;
	
	private TipoOrdineAppartenenzaAnimaleTO tipoAnimale;

	private Long tipoAnimaleLong;
	
	private String descrizioneTipoAnimale;
	
	private String specie;
	
	private Character sesso;
	
	private ParcoNaturaleTO parco;
	
	private Long parcoLong;
	
	private String descrizioneParco;
	
	private TipoStatoSaluteTO tipoStatoSalute;
	
	private Long statoSaluteLong;
	
	private String descrizioneStatoSalute;
	
	private Integer numEsemplari;
	
	
	public InfoCompleteAnimaleTO() {
		super();
	}

	

	public InfoCompleteAnimaleTO(Long id, String specie, Character sesso, Integer numEsemplari,
			Long tipoAnimaleLong, Long statoSaluteLong, Long parcoLong,
			String descrizioneTipoAnimale, String descrizioneParco, String descrizioneStatoSalute) {
		super();
		
		TipoOrdineAppartenenzaAnimaleTO tipoAnimaleTO = new TipoOrdineAppartenenzaAnimaleTO();
		
		ParcoNaturaleTO parcoTO = new ParcoNaturaleTO();
		
		TipoStatoSaluteTO statoSaluteTO = new TipoStatoSaluteTO();
		
		this.id = id;
		this.tipoAnimaleLong = tipoAnimaleLong;
		this.descrizioneTipoAnimale = descrizioneTipoAnimale;
		this.specie = specie;
		this.sesso = sesso;
		this.parcoLong = parcoLong;
		this.descrizioneParco = descrizioneParco;
		this.statoSaluteLong = statoSaluteLong;
		this.descrizioneStatoSalute = descrizioneStatoSalute;
		this.numEsemplari = numEsemplari;
		
		tipoAnimaleTO.setId(tipoAnimaleLong);
		tipoAnimaleTO.setDescrizione(descrizioneTipoAnimale);
		this.tipoAnimale = tipoAnimaleTO;
		
		parcoTO.setId(parcoLong);
		parcoTO.setNome(descrizioneParco);
		this.parco = parcoTO;
		
		statoSaluteTO.setId(statoSaluteLong);
		statoSaluteTO.setDescrizione(descrizioneStatoSalute);
		this.tipoStatoSalute = statoSaluteTO;
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


	public Long getTipoAnimaleLong() {
		return tipoAnimaleLong;
	}


	public void setTipoAnimaleLong(Long tipoAnimaleLong) {
		this.tipoAnimaleLong = tipoAnimaleLong;
	}


	public String getDescrizioneTipoAnimale() {
		return descrizioneTipoAnimale;
	}


	public void setDescrizioneTipoAnimale(String descrizioneTipoAnimale) {
		this.descrizioneTipoAnimale = descrizioneTipoAnimale;
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


	public TipoStatoSaluteTO getTipoStatoSalute() {
		return tipoStatoSalute;
	}


	public void setTipoStatoSalute(TipoStatoSaluteTO tipoStatoSalute) {
		this.tipoStatoSalute = tipoStatoSalute;
	}


	public Long getStatoSaluteLong() {
		return statoSaluteLong;
	}


	public void setStatoSaluteLong(Long statoSaluteLong) {
		this.statoSaluteLong = statoSaluteLong;
	}


	public String getDescrizioneStatoSalute() {
		return descrizioneStatoSalute;
	}


	public void setDescrizioneStatoSalute(String descrizioneStatoSalute) {
		this.descrizioneStatoSalute = descrizioneStatoSalute;
	}


	public Integer getNumEsemplari() {
		return numEsemplari;
	}


	public void setNumEsemplari(Integer numEsemplari) {
		this.numEsemplari = numEsemplari;
	}
	
	
}
