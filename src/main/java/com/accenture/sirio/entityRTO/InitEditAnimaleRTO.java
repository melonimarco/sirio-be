package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.InitAnimaleTO;

public class InitEditAnimaleRTO {
	
	private InitAnimaleTO initCreazione;
	private InfoCompleteAnimaleRTO dettaglio;
	
	public InitEditAnimaleRTO() {
		super();
	}

	public InitEditAnimaleRTO(InitAnimaleTO initCreazione, InfoCompleteAnimaleRTO dettaglio) {
		super();
		this.initCreazione = initCreazione;
		this.dettaglio = dettaglio;
	}

	public InitAnimaleTO getInitCreazione() {
		return initCreazione;
	}

	public void setInitCreazione(InitAnimaleTO initCreazione) {
		this.initCreazione = initCreazione;
	}

	public InfoCompleteAnimaleRTO getDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(InfoCompleteAnimaleRTO dettaglio) {
		this.dettaglio = dettaglio;
	}

	
	
	
}
