package com.accenture.sirio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;

@Entity
@Table(name = "tipo_entita_inserimento")
public class TipoEntitaInserimento {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	
	public TipoEntitaInserimento(TipoEntitaInserimentoTO tipoEntitaInserimentoTO) {
		this.id = tipoEntitaInserimentoTO.getId();
		this.descrizione = tipoEntitaInserimentoTO.getDescrizione();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
