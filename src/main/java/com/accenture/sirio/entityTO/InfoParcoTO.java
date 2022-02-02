package com.accenture.sirio.entityTO;

import java.util.List;

public class InfoParcoTO {
	private ParcoNaturaleTO parco;
	private List<InfoAnimaleTO> listAnimali;
	private List<InfoPiantaTO> listPiante;
	
	public InfoParcoTO() {
		
	}
	
	public InfoParcoTO(ParcoNaturaleTO parco, List<InfoAnimaleTO> listAnimali, List<InfoPiantaTO> listPiante) {
		super();
		this.parco = parco;
		this.listAnimali = listAnimali;
		this.listPiante = listPiante;
	}

	public ParcoNaturaleTO getParco() {
		return parco;
	}

	public void setParco(ParcoNaturaleTO parco) {
		this.parco = parco;
	}

	public List<InfoAnimaleTO> getListAnimali() {
		return listAnimali;
	}

	public void setListAnimali(List<InfoAnimaleTO> listAnimali) {
		this.listAnimali = listAnimali;
	}

	public List<InfoPiantaTO> getListPiante() {
		return listPiante;
	}

	public void setListPiante(List<InfoPiantaTO> listPiante) {
		this.listPiante = listPiante;
	}
	
	
	
}
