package com.accenture.sirio.entityTO;

public class TipoStatoSaluteTO {

	private Long id;
	
	private String descrizione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoStatoSaluteTO(Long id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public TipoStatoSaluteTO() {
		// TODO Auto-generated constructor stub
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "TipoStatoSaluteTO [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
}
