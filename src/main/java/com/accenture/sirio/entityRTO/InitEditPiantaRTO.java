package com.accenture.sirio.entityRTO;

public class InitEditPiantaRTO {
	InitCreazionePiantaRTO initCreazione;

	public InitEditPiantaRTO() {
		super();
	}

	public InitEditPiantaRTO(InitCreazionePiantaRTO initCreazione) {
		super();
		this.initCreazione = initCreazione;
	}

	public InitCreazionePiantaRTO getInitCreazione() {
		return initCreazione;
	}

	public void setInitCreazione(InitCreazionePiantaRTO initCreazione) {
		this.initCreazione = initCreazione;
	}
	
}
