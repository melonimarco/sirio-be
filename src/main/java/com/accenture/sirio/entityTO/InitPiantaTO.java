package com.accenture.sirio.entityTO;

import java.util.List;

import com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO;

public class InitPiantaTO {
	
	private List<TipoEntitaInserimentoTO> listTipoEntita;
	private List<TipoStagioneFiorituraTO> listStagioni;
	private List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta;
	private List<ParcoNaturaleCompletoRTO> listParchi;
	
	public InitPiantaTO(List<TipoEntitaInserimentoTO> listTipoEntita, List<TipoStagioneFiorituraTO> listStagioni,
			List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta, List<ParcoNaturaleCompletoRTO> listParchi) {
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
	public List<TipoOrdineAppartenenzaPiantaTO> getListTipoPianta() {
		return listTipoPianta;
	}
	public void setListTipoPianta(List<TipoOrdineAppartenenzaPiantaTO> listTipoPianta) {
		this.listTipoPianta = listTipoPianta;
	}
	public List<ParcoNaturaleCompletoRTO> getListParchi() {
		return listParchi;
	}
	public void setListParchi(List<ParcoNaturaleCompletoRTO> listParchi) {
		this.listParchi = listParchi;
	}
	
	@Override
	public String toString() {
		return "InitPiantaTO [listTipoEntita=" + listTipoEntita + ", listStagioni=" + listStagioni + ", listTipoPianta="
				+ listTipoPianta + ", listParchi=" + listParchi + "]";
	}
	
	
	

}
