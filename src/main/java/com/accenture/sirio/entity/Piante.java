package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "piante")
public class Piante {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "specie", nullable = false)
	private String specie;
	
	@ManyToOne
	@JoinColumn(name = "ordine_appartenenza", insertable = false, updatable = false)
	private TipoOrdineAppartenenzaPiante tipoOrdineAppartenenzaPiante;
	
	@ManyToOne
	@JoinColumn(name = "stagione_fioritura", insertable = false, updatable = false)
	private TipoStagioneFioritura tipoStagioneFioritura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public TipoOrdineAppartenenzaPiante getTipoOrdineAppartenenzaPiante() {
		return tipoOrdineAppartenenzaPiante;
	}

	public void setTipoOrdineAppartenenzaPiante(TipoOrdineAppartenenzaPiante tipoOrdineAppartenenzaPiante) {
		this.tipoOrdineAppartenenzaPiante = tipoOrdineAppartenenzaPiante;
	}

	public TipoStagioneFioritura getTipoStagioneFioritura() {
		return tipoStagioneFioritura;
	}

	public void setTipoStagioneFioritura(TipoStagioneFioritura tipoStagioneFioritura) {
		this.tipoStagioneFioritura = tipoStagioneFioritura;
	}
}
