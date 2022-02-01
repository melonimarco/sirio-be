package com.accenture.sirio.entityTO;

import java.util.List;

public class InfoParcoTO {
	private ParcoNaturaleTO parco;
	private List<AnimaleTO> listAnimali;
	private List<PiantaTO> listPiante;
	
	public InfoParcoTO() {
		
	}
	
	public InfoParcoTO(ParcoNaturaleTO parco, List<AnimaleTO> listAnimali, List<PiantaTO> listPiante) {
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

	public List<AnimaleTO> getListAnimali() {
		return listAnimali;
	}

	public void setListAnimali(List<AnimaleTO> listAnimali) {
		this.listAnimali = listAnimali;
	}

	public List<PiantaTO> getListPiante() {
		return listPiante;
	}

	public void setListPiante(List<PiantaTO> listPiante) {
		this.listPiante = listPiante;
	}
	
	
	
}
