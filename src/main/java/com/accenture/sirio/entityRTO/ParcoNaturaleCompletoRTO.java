package com.accenture.sirio.entityRTO;

import com.accenture.sirio.entityTO.RegioneTO;

public class ParcoNaturaleCompletoRTO {
	
	private Long id;

	private String nome;
	
	private RegioneTO regione;

	public ParcoNaturaleCompletoRTO() {
		super();
	}

	public ParcoNaturaleCompletoRTO(Long id, String nome, Long idRegione, String nomeRegione) {
		super();
		
		RegioneTO regioneTO = new RegioneTO();
		
		this.id = id;
		this.nome = nome;
		
		regioneTO.setId(idRegione);
		regioneTO.setNome(nomeRegione);
		this.regione = regioneTO;
		
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

	public RegioneTO getRegione() {
		return regione;
	}

	public void setRegione(RegioneTO regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
		return "ParcoNaturaleCompletoRTO [id=" + id + ", nome=" + nome + ", regione=" + regione + "]";
	}

	

}
