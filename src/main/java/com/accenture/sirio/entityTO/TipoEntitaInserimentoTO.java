package com.accenture.sirio.entityTO;

public class TipoEntitaInserimentoTO {

	
	private Long id;
	
	private String descrizione;
	
	public TipoEntitaInserimentoTO(Long id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "TipoEntitaInserimentoTO [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
}
