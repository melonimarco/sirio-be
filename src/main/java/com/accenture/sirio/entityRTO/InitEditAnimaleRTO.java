package com.accenture.sirio.entityRTO;


public class InitEditAnimaleRTO {
	
	private InitCreazioneRTO initCreazione;

	public InitEditAnimaleRTO() {
		super();
	}

	public InitEditAnimaleRTO(InitCreazioneRTO initCreazione) {
		super();
		this.initCreazione = initCreazione;
	}

	public InitCreazioneRTO getInitCreazione() {
		return initCreazione;
	}

	public void setInitCreazione(InitCreazioneRTO initCreazione) {
		this.initCreazione = initCreazione;
	}
	
	
}
