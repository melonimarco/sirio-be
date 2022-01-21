package com.accenture.sirio.entityTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParcoNaturaleTO {
	
	private Long id;

	@JsonProperty(value="descrizione")
	private String nome;
	
	public ParcoNaturaleTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty(value="descrizione")
	public String getNome() {
		return nome;
	}
	
	@JsonProperty(value="descrizione")
	public void setNome(String nome) {
		this.nome = nome;
	}

}
