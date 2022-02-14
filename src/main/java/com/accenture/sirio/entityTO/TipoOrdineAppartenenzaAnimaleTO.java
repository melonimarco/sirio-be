package com.accenture.sirio.entityTO;

public class TipoOrdineAppartenenzaAnimaleTO {

	private Long id;
	
	private String descrizione;
	
	public TipoOrdineAppartenenzaAnimaleTO(Long id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public TipoOrdineAppartenenzaAnimaleTO() {
		// TODO Auto-generated constructor stub
		super();
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
		return "TipoOrdineAppartenenzaAnimaleTO [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
}
