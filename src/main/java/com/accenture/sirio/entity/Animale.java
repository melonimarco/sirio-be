package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.accenture.sirio.entityTO.AnimaleTO;

@Entity
@Table(name = "animali")
public class Animale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "specie", nullable = false)
	private String specie;
	
	@Column(name = "sesso", nullable = false)
	private Character sesso;
	
	@Column(name = "numero_esemplari", nullable = false)
	private Integer numeroEsemplari;
	
	@ManyToOne
	@JoinColumn(name = "ordine_appartenenza", insertable = false, updatable = false)
	private TipoOrdineAppartenenzaAnimale tipoOrdineAppartenenzaAnimaliBean;
	
	@Column(name = "ordine_appartenenza", nullable = false)
	private Long tipoOrdineAppartenenzaAnimali;
	
	@ManyToOne
	@JoinColumn(name = "stato_salute", insertable = false, updatable = false)
	private TipoStatoSalute tipoStatoSaluteBean;
	
	@Column(name = "stato_salute", nullable = false)
	private Long tipoStatoSalute;
	
	@ManyToOne
	@JoinColumn(name = "parco_naturale", insertable = false, updatable = false)
	private ParcoNaturale parcoNaturaleBean;
	
	@Column(name = "parco_naturale", nullable = false)
	private Long parcoNaturale;

	public Animale() {
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

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public Integer getNumeroEsemplari() {
		return numeroEsemplari;
	}

	public void setNumeroEsemplari(Integer numeroEsemplari) {
		this.numeroEsemplari = numeroEsemplari;
	}

	public TipoOrdineAppartenenzaAnimale getTipoOrdineAppartenenzaAnimaliBean() {
		return tipoOrdineAppartenenzaAnimaliBean;
	}

	public void setTipoOrdineAppartenenzaAnimaliBean(TipoOrdineAppartenenzaAnimale tipoOrdineAppartenenzaAnimaliBean) {
		this.tipoOrdineAppartenenzaAnimaliBean = tipoOrdineAppartenenzaAnimaliBean;
	}

	public Long getTipoOrdineAppartenenzaAnimali() {
		return tipoOrdineAppartenenzaAnimali;
	}

	public void setTipoOrdineAppartenenzaAnimali(Long tipoOrdineAppartenenzaAnimali) {
		this.tipoOrdineAppartenenzaAnimali = tipoOrdineAppartenenzaAnimali;
	}

	public TipoStatoSalute getTipoStatoSaluteBean() {
		return tipoStatoSaluteBean;
	}

	public void setTipoStatoSaluteBean(TipoStatoSalute tipoStatoSaluteBean) {
		this.tipoStatoSaluteBean = tipoStatoSaluteBean;
	}

	public Long getTipoStatoSalute() {
		return tipoStatoSalute;
	}

	public void setTipoStatoSalute(Long tipoStatoSalute) {
		this.tipoStatoSalute = tipoStatoSalute;
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
