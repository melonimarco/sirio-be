package com.accenture.sirio.entityRTO;

import java.util.List;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;
import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;

public class InitCreazionePiantaRTO {
	List<TipoEntitaInserimentoTO> listTipoEntita;
	List<TipoStagioneFiorituraTO> listStagioni;
	List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta;
	List<ParcoNaturaleTO> listParchi;
	InfoCompletePiantaRTO dettaglio;
	public InitCreazionePiantaRTO() {
		super();
	}
	public InitCreazionePiantaRTO(List<TipoEntitaInserimentoTO> listTipoEntita,
			List<TipoStagioneFiorituraTO> listStagioni, List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta,
			List<ParcoNaturaleTO> listParchi, InfoCompletePiantaRTO dettaglio) {
		super();
		this.listTipoEntita = listTipoEntita;
		this.listStagioni = listStagioni;
		this.listTipoPianta = listTipoPianta;
		this.listParchi = listParchi;
		this.dettaglio = dettaglio;
	}
	public List<TipoEntitaInserimentoTO> getListTipoEntita() {
		return listTipoEntita;
	}
	public void setListTipoEntita(List<TipoEntitaInserimentoTO> listTipoEntita) {
		this.listTipoEntita = listTipoEntita;
	}
	public List<TipoStagioneFiorituraTO> getListStagioni() {
		return listStagioni;
	}
	public void setListStagioni(List<TipoStagioneFiorituraTO> listStagioni) {
		this.listStagioni = listStagioni;
	}
	public List<TipoOrdineAppartenenzaPiantaTO> getListTipoPianta() {
		return listTipoPianta;
	}
	public void setListTipoPianta(List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta) {
		this.listTipoPianta = listTipoPianta;
	}
	public List<ParcoNaturaleTO> getListParchi() {
		return listParchi;
	}
	public void setListParchi(List<ParcoNaturaleTO> listParchi) {
		this.listParchi = listParchi;
	}
	public InfoCompletePiantaRTO getDettaglio() {
		return dettaglio;
	}
	public void setDettaglio(InfoCompletePiantaRTO dettaglio) {
		this.dettaglio = dettaglio;
	}
	
	
}
