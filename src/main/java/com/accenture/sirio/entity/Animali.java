package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animali")
public class Animali {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "specie", nullable = false)
	private String specie;
	
	@Column(name = "sesso", nullable = false)
	private Character sesso;
	
	@Column(name = "numero_esemplari", nullable = false)
	private int numeroEsemplari;
	
	@ManyToOne
	@JoinColumn(name = "tipo_ordine_appartenenza_animali", insertable = false, updatable = false)
	private TipoOrdineAppartenenzaAnimali tipoOrdineAppartenenzaAnimali;
	
	@ManyToOne
	@JoinColumn(name = "eta", insertable = false, updatable = false)
	private TipoEta tipoEta;
	
	@ManyToOne
	@JoinColumn(name = "stato_salute", insertable = false, updatable = false)
	private TipoStatoSalute tipoStatoSalute;

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

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public int getNumeroEsemplari() {
		return numeroEsemplari;
	}

	public void setNumeroEsemplari(int numeroEsemplari) {
		this.numeroEsemplari = numeroEsemplari;
	}

	public TipoOrdineAppartenenzaAnimali getTipoOrdineAppartenenzaAnimali() {
		return tipoOrdineAppartenenzaAnimali;
	}

	public void setTipoOrdineAppartenenzaAnimali(TipoOrdineAppartenenzaAnimali tipoOrdineAppartenenzaAnimali) {
		this.tipoOrdineAppartenenzaAnimali = tipoOrdineAppartenenzaAnimali;
	}

	public TipoEta getTipoEta() {
		return tipoEta;
	}

	public void setTipoEta(TipoEta tipoEta) {
		this.tipoEta = tipoEta;
	}

	public TipoStatoSalute getTipoStatoSalute() {
		return tipoStatoSalute;
	}

	public void setTipoStatoSalute(TipoStatoSalute tipoStatoSalute) {
		this.tipoStatoSalute = tipoStatoSalute;
	}
}
