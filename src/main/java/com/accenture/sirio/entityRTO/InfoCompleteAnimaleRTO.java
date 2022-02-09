package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;

public class InfoCompleteAnimaleRTO {
	
	private Long id;
	
	private TipoOrdineAppartenenzaAnimaleTO tipoAnimale;
	
	private String specie;
	
	private Character sesso;
	
	private ParcoNaturaleTO parco;
	
	private TipoStatoSaluteTO tipoStatoSalute;
	
	private Integer numEsemplari;
	
	
	public InfoCompleteAnimaleRTO() {
		super();
	}

	public InfoCompleteAnimaleRTO(Long id, TipoOrdineAppartenenzaAnimaleTO tipoAnimale, String specie, Character sesso,
			ParcoNaturaleTO parco, TipoStatoSaluteTO tipoStatoSalute, Integer numEsemplari) {
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
