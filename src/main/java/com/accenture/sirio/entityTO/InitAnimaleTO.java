package com.accenture.sirio.entityTO;

import java.util.List;

public class InitAnimaleTO {
	
	private List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList;
	private List<TipoStatoSaluteTO> tipoStatoSaluteTOList;
	private List<TipoOrdineAppartenenzaAnimaliTO> tipoOrdineAppartenenzaAnimaliTOList;
	private List<TipoEtaTO> tipoEtaTOList;
	private List<ParcoNaturaleTO> parcoNaturaleTOList;
	
	public InitAnimaleTO(List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList,
			List<TipoStatoSaluteTO> tipoStatoSaluteTOList,
			List<TipoOrdineAppartenenzaAnimaliTO> tipoOrdineAppartenenzaAnimaliTOList, List<TipoEtaTO> tipoEtaTOList,
			List<ParcoNaturaleTO> parcoNaturaleTOList) {
		super();
		this.tipoEntitaInserimentoTOList = tipoEntitaInserimentoTOList;
		this.tipoStatoSaluteTOList = tipoStatoSaluteTOList;
		this.tipoOrdineAppartenenzaAnimaliTOList = tipoOrdineAppartenenzaAnimaliTOList;
		this.tipoEtaTOList = tipoEtaTOList;
		this.parcoNaturaleTOList = parcoNaturaleTOList;
	}
	
	public List<TipoEntitaInserimentoTO> getTipoEntitaInserimentoTOList() {
		return tipoEntitaInserimentoTOList;
	}
	public void setTipoEntitaInserimentoTOList(List<TipoEntitaInserimentoTO> tipoEntitaInserimentoTOList) {
		this.tipoEntitaInserimentoTOList = tipoEntitaInserimentoTOList;
	}
	public List<TipoStatoSaluteTO> getTipoStatoSaluteTOList() {
		return tipoStatoSaluteTOList;
	}
	public void setTipoStatoSaluteTOList(List<TipoStatoSaluteTO> tipoStatoSaluteTOList) {
		this.tipoStatoSaluteTOList = tipoStatoSaluteTOList;
	}
	public List<TipoOrdineAppartenenzaAnimaliTO> getTipoOrdineAppartenenzaAnimaliTOList() {
		return tipoOrdineAppartenenzaAnimaliTOList;
	}
	public void setTipoOrdineAppartenenzaAnimaliTOList(
			List<TipoOrdineAppartenenzaAnimaliTO> tipoOrdineAppartenenzaAnimaliTOList) {
		this.tipoOrdineAppartenenzaAnimaliTOList = tipoOrdineAppartenenzaAnimaliTOList;
	}
	public List<TipoEtaTO> getTipoEtaTOList() {
		return tipoEtaTOList;
	}
	public void setTipoEtaTOList(List<TipoEtaTO> tipoEtaTOList) {
		this.tipoEtaTOList = tipoEtaTOList;
	}
	public List<ParcoNaturaleTO> getParcoNaturaleTOList() {
		return parcoNaturaleTOList;
	}
	public void setParcoNaturaleTOList(List<ParcoNaturaleTO> parcoNaturaleTOList) {
		this.parcoNaturaleTOList = parcoNaturaleTOList;
	}
	
	
}
