package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.ListRegioniTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.ParcoSalvataggioTO;

public class InitEditParcoRTO {
	
	private ListRegioniTO listRegioni;
	private ParcoSalvataggioTO dettaglio;
	
	public InitEditParcoRTO() {
		super();
	}
	
	public InitEditParcoRTO(ListRegioniTO listRegioni, ParcoSalvataggioTO dettaglio) {
		super();
		this.listRegioni = listRegioni;
		this.dettaglio = dettaglio;
	}
	
	public ListRegioniTO getListRegioni() {
		return listRegioni;
	}
	
	public void setListRegioni(ListRegioniTO listRegioni) {
		this.listRegioni = listRegioni;
	}
	
	public ParcoSalvataggioTO getDettaglio() {
		return dettaglio;
	}
	
	public void setDettaglio(ParcoSalvataggioTO dettaglio) {
		this.dettaglio = dettaglio;
	}
	
	@Override
	public String toString() {
		return "InitEditParcoRTO [listRegioni=" + listRegioni + ", dettaglio=" + dettaglio + "]";
	}
	
	
	
	
}
