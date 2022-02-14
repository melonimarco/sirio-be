package com.accenture.sirio.entityRTO;

import java.util.List;

import com.accenture.sirio.entityTO.ParcoNaturaleTO;

public class InfoParcoRTO {
	private ParcoNaturaleTO parco;
	private List<InfoAnimaleRTO> listAnimali;
	private List<InfoPiantaRTO> listPiante;
	
	public InfoParcoRTO() {
		
	}
	
	public InfoParcoRTO(ParcoNaturaleTO parco, List<InfoAnimaleRTO> listAnimali, List<InfoPiantaRTO> listPiante) {
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

	public List<InfoAnimaleRTO> getListAnimali() {
		return listAnimali;
	}

	public void setListAnimali(List<InfoAnimaleRTO> listAnimali) {
		this.listAnimali = listAnimali;
	}

	public List<InfoPiantaRTO> getListPiante() {
		return listPiante;
	}

	public void setListPiante(List<InfoPiantaRTO> listPiante) {
		this.listPiante = listPiante;
	}

	@Override
	public String toString() {
		return "InfoParcoRTO [parco=" + parco + ", listAnimali=" + listAnimali + ", listPiante=" + listPiante + "]";
	}
	
	
	
}
