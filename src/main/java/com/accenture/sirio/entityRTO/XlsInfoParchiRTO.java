package com.accenture.sirio.entityRTO;

public class XlsInfoParchiRTO{
	
	private Long idParco;
	private String nomeParco;
	private String regione;
	private String tipologia;
	private String specie;
	
	public XlsInfoParchiRTO() {
		super();
	}

	public XlsInfoParchiRTO(Long idParco, String nomeParco, String regione, String tipologia, String specie) {
		super();
		this.idParco = idParco;
		this.nomeParco = nomeParco;
		this.regione = regione;
		this.tipologia = tipologia;
		this.specie = specie;
	}

	public Long getIdParco() {
		return idParco;
	}

	public void setIdParco(Long idParco) {
		this.idParco = idParco;
	}

	public String getNomeParco() {
		return nomeParco;
	}

	public void setNomeParco(String nomeParco) {
		this.nomeParco = nomeParco;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	@Override
	public String toString() {
		return "XlsInfoParchiRTO [idParco=" + idParco + ", nomeParco=" + nomeParco + ", regione=" + regione
				+ ", tipologia=" + tipologia + ", specie=" + specie + "]";
	}

}
