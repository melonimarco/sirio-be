package com.accenture.sirio.entityRTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;


//Mettere String e gestione da AnimaleTO
public class InfoAnimaleRTO {
	
	private Long id;
	
	private Long tipoAnimaleLong;
	
	private TipoOrdineAppartenenzaAnimaleTO tipoAnimale;
	
	private String descrizioneTipoAnimale; 
	
	private String specie;
	
	
	private Character sesso;
	
	public InfoAnimaleRTO() {
		super();
	}
	
	

	public InfoAnimaleRTO(Long id, Long tipoAnimaleLong, String specie, Character sesso, String descrizioneTipoAnimale) {
		super();
		
		TipoOrdineAppartenenzaAnimaleTO tipoAnimaleTO = new TipoOrdineAppartenenzaAnimaleTO();
		
		this.id = id;
		this.tipoAnimaleLong = tipoAnimaleLong;
		this.descrizioneTipoAnimale = descrizioneTipoAnimale;
		this.specie = specie;
		this.sesso = sesso;
		
		
		tipoAnimaleTO.setId(tipoAnimaleLong);
		tipoAnimaleTO.setDescrizione(descrizioneTipoAnimale);
		this.tipoAnimale=tipoAnimaleTO;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipoAnimaleLong() {
		return tipoAnimaleLong;
	}

	public void setTipoAnimaleLong(Long tipoAnimaleLong) {
		this.tipoAnimaleLong = tipoAnimaleLong;
	}

	public TipoOrdineAppartenenzaAnimaleTO getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(TipoOrdineAppartenenzaAnimaleTO tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
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

}
