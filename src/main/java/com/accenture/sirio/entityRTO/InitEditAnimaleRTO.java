package com.accenture.sirio.entityRTO;


public class InitEditAnimaleRTO {
	
	private InitCreazioneAnimaleRTO initCreazione;

	public InitEditAnimaleRTO() {
		super();
	}

	public InitEditAnimaleRTO(InitCreazioneAnimaleRTO initCreazione) {
		super();
		this.initCreazione = initCreazione;
	}

	public InitCreazioneAnimaleRTO getInitCreazione() {
		return initCreazione;
	}

	public void setInitCreazione(InitCreazioneAnimaleRTO initCreazione) {
		this.initCreazione = initCreazione;
	}
	
	
}
