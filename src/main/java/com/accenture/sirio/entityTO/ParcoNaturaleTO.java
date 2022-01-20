package com.accenture.sirio.entityTO;

import com.accenture.sirio.entity.Regione;

public class ParcoNaturaleTO {
	

	private Long id;
	

	private String nome;
	

	private Regione regione;

	public ParcoNaturaleTO(Long id, String nome, Regione regione) {
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

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}
}
