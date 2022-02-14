package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.InitPiantaTO;

public class InitEditPiantaRTO {
	private InitPiantaTO initCreazione;
	private InfoCompletePiantaRTO dettaglio;

	public InitEditPiantaRTO() {
		super();
	}

	public InitEditPiantaRTO(InitPiantaTO initCreazione, InfoCompletePiantaRTO dettaglio) {
		super();
		this.initCreazione = initCreazione;
		this.dettaglio = dettaglio;
	}

	public InitPiantaTO getInitCreazione() {
		return initCreazione;
	}

	public void setInitCreazione(InitPiantaTO initCreazione) {
		this.initCreazione = initCreazione;
	}

	public InfoCompletePiantaRTO getDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(InfoCompletePiantaRTO dettaglio) {
		this.dettaglio = dettaglio;
	}

	@Override
	public String toString() {
		return "InitEditPiantaRTO [initCreazione=" + initCreazione + ", dettaglio=" + dettaglio + "]";
	}
	
	
	
}
