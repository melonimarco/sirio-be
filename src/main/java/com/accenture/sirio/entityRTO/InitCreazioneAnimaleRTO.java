package com.accenture.sirio.entityRTO;

import java.util.List;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;

public class InitCreazioneAnimaleRTO {
	List<TipoEntitaInserimentoTO> listEntita;
	List<TipoStatoSaluteTO> listTipoStatoSalute;
	List<TipoOrdineAppartenenzaAnimaleTO> listTipoAnimale;
	List<ParcoNaturaleTO> listParchi;
	InfoCompleteAnimaleRTO dettaglio;
	

	public InitCreazioneAnimaleRTO() {
		super();
	}
	
	public InitCreazioneAnimaleRTO(List<TipoEntitaInserimentoTO> listEntita, List<TipoStatoSaluteTO> listTipoStatoSalute,
			List<TipoOrdineAppartenenzaAnimaleTO> listTipoAnimale, List<ParcoNaturaleTO> listParchi,
			InfoCompleteAnimaleRTO dettaglio) {
		super();
		this.listEntita = listEntita;
		this.listTipoStatoSalute = listTipoStatoSalute;
		this.listTipoAnimale = listTipoAnimale;
		this.listParchi = listParchi;
		this.dettaglio = dettaglio;
	}

	public List<TipoEntitaInserimentoTO> getListEntita() {
		return listEntita;
	}
	public void setListEntita(List<TipoEntitaInserimentoTO> listEntita) {
		this.listEntita = listEntita;
	}
	public List<TipoStatoSaluteTO> getListTipoStatoSalute() {
		return listTipoStatoSalute;
	}
	public void setListTipoStatoSalute(List<TipoStatoSaluteTO> listTipoStatoSalute) {
		this.listTipoStatoSalute = listTipoStatoSalute;
	}
	public List<TipoOrdineAppartenenzaAnimaleTO> getListTipoAnimale() {
		return listTipoAnimale;
	}
	public void setListTipoAnimale(List<TipoOrdineAppartenenzaAnimaleTO> listTipoAnimale) {
		this.listTipoAnimale = listTipoAnimale;
	}
	public List<ParcoNaturaleTO> getListParchi() {
		return listParchi;
	}
	public void setListParchi(List<ParcoNaturaleTO> listParchi) {
		this.listParchi = listParchi;
	}
	public InfoCompleteAnimaleRTO getDettaglio() {
		return dettaglio;
	}
	public void setDettaglio(InfoCompleteAnimaleRTO dettaglio) {
		this.dettaglio = dettaglio;
	}
	
	
}
