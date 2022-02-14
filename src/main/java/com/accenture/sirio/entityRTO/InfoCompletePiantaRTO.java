package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;

public class InfoCompletePiantaRTO {
	
	private Long id;
	
	private String specie;

	private TipoOrdineAppartenenzaPiantaTO tipoPianta;

	private TipoStagioneFiorituraTO stagioneFioritura;

	private ParcoNaturaleTO parco;

	public InfoCompletePiantaRTO() {
		super();
	}

	public InfoCompletePiantaRTO(Long id, String specie, TipoOrdineAppartenenzaPiantaTO tipoPianta,
			TipoStagioneFiorituraTO stagioneFioritura, ParcoNaturaleTO parco) {
		super();
		this.id = id;
		this.specie = specie;
		this.tipoPianta = tipoPianta;
		this.stagioneFioritura = stagioneFioritura;
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
		return stagioneFioritura;
	}

	public void setStagioneFioritura(TipoStagioneFiorituraTO stagioneFioritura) {
		this.stagioneFioritura = stagioneFioritura;
	}

	public ParcoNaturaleTO getParco() {
		return parco;
	}

	public void setParco(ParcoNaturaleTO parco) {
		this.parco = parco;
	}

	@Override
	public String toString() {
		return "InfoCompletePiantaRTO [id=" + id + ", specie=" + specie + ", tipoPianta=" + tipoPianta
				+ ", stagioneFioritura=" + stagioneFioritura + ", parco=" + parco + "]";
	}
	
	

}
