package com.accenture.sirio.entityTO;

import java.util.List;

public class InitPiantaTO {
	
	private List<TipoEntitaInserimentoTO> listTipoEntita;
	private List<TipoStagioneFiorituraTO> listStagioni;
	private List<TipoOrdineAppartenenzaPianteTO> listTipoPianta;
	private List<ParcoNaturaleTO> listParchi;
	
	public InitPiantaTO(List<TipoEntitaInserimentoTO> listTipoEntita, List<TipoStagioneFiorituraTO> listStagioni,
			List<TipoOrdineAppartenenzaPianteTO> listTipoPianta, List<ParcoNaturaleTO> listParchi) {
		super();
		this.listTipoEntita = listTipoEntita;
		this.listStagioni = listStagioni;
		this.listTipoPianta = listTipoPianta;
		this.listParchi = listParchi;
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
	public List<TipoOrdineAppartenenzaPianteTO> getListTipoPianta() {
		return listTipoPianta;
	}
	public void setListTipoPianta(List<TipoOrdineAppartenenzaPianteTO> listTipoPianta) {
		this.listTipoPianta = listTipoPianta;
	}
	public List<ParcoNaturaleTO> getListParchi() {
		return listParchi;
	}
	public void setListParchi(List<ParcoNaturaleTO> listParchi) {
		this.listParchi = listParchi;
	}
	
	
	

}
