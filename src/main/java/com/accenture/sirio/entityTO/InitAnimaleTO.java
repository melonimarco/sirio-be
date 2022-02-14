package com.accenture.sirio.entityTO;

import java.util.List;

public class InitAnimaleTO {
	
	private List<TipoEntitaInserimentoTO> listTipoEntita;
	private List<TipoStatoSaluteTO> listTipoStatoSalute;
	private List<TipoOrdineAppartenenzaAnimaleTO> listTipoAnimale;
	private List<ParcoNaturaleTO> listParchi;
	
	public InitAnimaleTO(List<TipoEntitaInserimentoTO> listTipoEntita, List<TipoStatoSaluteTO> listTipoStatoSalute,
			List<TipoOrdineAppartenenzaAnimaleTO> listTipoAnimale,
			List<ParcoNaturaleTO> listParchi) {
		super();
		this.listTipoEntita = listTipoEntita;
		this.listTipoStatoSalute = listTipoStatoSalute;
		this.listTipoAnimale = listTipoAnimale;
		this.listParchi = listParchi;
	}
	public List<TipoEntitaInserimentoTO> getListTipoEntita() {
		return listTipoEntita;
	}
	public void setListTipoEntita(List<TipoEntitaInserimentoTO> listTipoEntita) {
		this.listTipoEntita = listTipoEntita;
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
	@Override
	public String toString() {
		return "InitAnimaleTO [listTipoEntita=" + listTipoEntita + ", listTipoStatoSalute=" + listTipoStatoSalute
				+ ", listTipoAnimale=" + listTipoAnimale + ", listParchi=" + listParchi + "]";
	}
	
	
	
	
}
