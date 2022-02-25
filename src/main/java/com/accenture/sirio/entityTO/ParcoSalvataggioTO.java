package com.accenture.sirio.entityTO;

public class ParcoSalvataggioTO {
	
	private Long id;

	private String nome;
	
	private Long regione;

	public ParcoSalvataggioTO() {
		super();
	}

	public ParcoSalvataggioTO(Long id, String nome, Long regione) {
		super();
		this.id = id;
		this.nome = nome;
		this.regione = regione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRegione() {
		return regione;
	}

	public void setRegione(Long regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
		return "ParcoSalvataggioTO [id=" + id + ", nome=" + nome + ", regione=" + regione + "]";
	}
	
	

	
	
}
