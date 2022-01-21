package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "parco_naturale")
public class ParcoNaturale {
	
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@JsonProperty(value="descrizione")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "regione", insertable = false, updatable = false)
	private Regione regione;

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

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}
}
