package com.accenture.sirio.entityTO;

import java.util.List;

public class InitPiantaTO {
	
	private List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList;
	private List<TipoStagioneFiorituraTO> tipoStagioneFiorituraList;
	private List<TipoOrdineAppartenenzaPianteTO> tipoOrdineAppartenenzaPianteList;
	private List<ParcoNaturaleTO> parcoNaturaleList;
	
	public InitPiantaTO(List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList,
			List<TipoStagioneFiorituraTO> tipoStagioneFiorituraList,
			List<TipoOrdineAppartenenzaPianteTO> tipoOrdineAppartenenzaPianteList,
			List<ParcoNaturaleTO> parcoNaturaleList) {
		super();
		this.tipoEntitaInserimentoTOList = tipoEntitaInserimentoTOList;
		this.tipoStagioneFiorituraList = tipoStagioneFiorituraList;
		this.tipoOrdineAppartenenzaPianteList = tipoOrdineAppartenenzaPianteList;
		this.parcoNaturaleList = parcoNaturaleList;
	}

	public List<TipoEntitaInserimentoTO> getTipoEntitaInserimentoTOList() {
		return tipoEntitaInserimentoTOList;
	}

	public void setTipoEntitaInserimentoTOList(List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList) {
		this.tipoEntitaInserimentoTOList = tipoEntitaInserimentoTOList;
	}

	public List<TipoStagioneFiorituraTO> getTipoStagioneFiorituraList() {
		return tipoStagioneFiorituraList;
	}

	public void setTipoStagioneFiorituraList(List<TipoStagioneFiorituraTO> tipoStagioneFiorituraList) {
		this.tipoStagioneFiorituraList = tipoStagioneFiorituraList;
	}

	public List<TipoOrdineAppartenenzaPianteTO> getTipoOrdineAppartenenzaPianteList() {
		return tipoOrdineAppartenenzaPianteList;
	}

	public void setTipoOrdineAppartenenzaPianteList(List<TipoOrdineAppartenenzaPianteTO> tipoOrdineAppartenenzaPianteList) {
		this.tipoOrdineAppartenenzaPianteList = tipoOrdineAppartenenzaPianteList;
	}

	public List<ParcoNaturaleTO> getParcoNaturaleList() {
		return parcoNaturaleList;
	}

	public void setParcoNaturaleList(List<ParcoNaturaleTO> parcoNaturaleList) {
		this.parcoNaturaleList = parcoNaturaleList;
	}
	

}
