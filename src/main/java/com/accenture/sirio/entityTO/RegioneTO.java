package com.accenture.sirio.entityTO;

public class RegioneTO {

	private Long id;
	
	private String nome;
	
	public RegioneTO() {
		super();
	}

	public RegioneTO(Long id, String nome) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "RegioneTO [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
