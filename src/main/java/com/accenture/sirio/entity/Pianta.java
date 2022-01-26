package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.accenture.sirio.entityTO.PiantaTO;

@Entity
@Table(name = "piante")
public class Pianta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "specie", nullable = false)
	private String specie;
	
	@ManyToOne
	@JoinColumn(name = "ordine_appartenenza", insertable = false, updatable = false)
	private TipoOrdineAppartenenzaPianta tipoOrdineAppartenenzaPianteBean;
	
	@Column(name = "ordine_appartenenza", nullable = false)
	private Long tipoOrdineAppartenenzaPiante;
	
	@ManyToOne
	@JoinColumn(name = "stagione_fioritura", insertable = false, updatable = false)
	private TipoStagioneFioritura tipoStagioneFiorituraBean;
	
	@Column(name = "stagione_fioritura", nullable = false)
	private Long tipoStagioneFioritura;
	
	@ManyToOne
	@JoinColumn(name = "parco_naturale", insertable = false, updatable = false)
	private ParcoNaturale parcoNaturaleBean;
	
	@Column(name = "parco_naturale", nullable = false)
	private Long parcoNaturale;

	public Pianta(PiantaTO piantaTO) {
		this.specie = piantaTO.getSpecie();
		this.tipoOrdineAppartenenzaPiante = piantaTO.getTipoPianta();
		this.tipoStagioneFioritura = piantaTO.getStagioneFioritura();
		this.parcoNaturale = piantaTO.getParco();
	}

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

	public TipoOrdineAppartenenzaPianta getTipoOrdineAppartenenzaPianteBean() {
		return tipoOrdineAppartenenzaPianteBean;
	}

	public void setTipoOrdineAppartenenzaPianteBean(TipoOrdineAppartenenzaPianta tipoOrdineAppartenenzaPianteBean) {
		this.tipoOrdineAppartenenzaPianteBean = tipoOrdineAppartenenzaPianteBean;
	}

	public Long getTipoOrdineAppartenenzaPiante() {
		return tipoOrdineAppartenenzaPiante;
	}

	public void setTipoOrdineAppartenenzaPiante(Long tipoOrdineAppartenenzaPiante) {
		this.tipoOrdineAppartenenzaPiante = tipoOrdineAppartenenzaPiante;
	}

	public TipoStagioneFioritura getTipoStagioneFiorituraBean() {
		return tipoStagioneFiorituraBean;
	}

	public void setTipoStagioneFiorituraBean(TipoStagioneFioritura tipoStagioneFiorituraBean) {
		this.tipoStagioneFiorituraBean = tipoStagioneFiorituraBean;
	}

	public Long getTipoStagioneFioritura() {
		return tipoStagioneFioritura;
	}

	public void setTipoStagioneFioritura(Long tipoStagioneFioritura) {
		this.tipoStagioneFioritura = tipoStagioneFioritura;
	}

	public ParcoNaturale getParcoNaturaleBean() {
		return parcoNaturaleBean;
	}

	public void setParcoNaturaleBean(ParcoNaturale parcoNaturaleBean) {
		this.parcoNaturaleBean = parcoNaturaleBean;
	}

	public Long getParcoNaturale() {
		return parcoNaturale;
	}

	public void setParcoNaturale(Long parcoNaturale) {
		this.parcoNaturale = parcoNaturale;
	}

	
	
	
}
