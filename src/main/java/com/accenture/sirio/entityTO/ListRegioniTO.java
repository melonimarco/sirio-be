package com.accenture.sirio.entityTO;

import java.util.List;

public class ListRegioniTO {
	private List<RegioneTO> listRegioni;

	
	
	public ListRegioniTO() {
		super();
	}

	public ListRegioniTO(List<RegioneTO> listRegioni) {
		super();
		this.listRegioni = listRegioni;
	}

	public List<RegioneTO> getListRegioni() {
		return listRegioni;
	}

	public void setListRegioni(List<RegioneTO> listRegioni) {
		this.listRegioni = listRegioni;
	}

	@Override
	public String toString() {
		return "ListRegioniTO [listRegioni=" + listRegioni + "]";
	}	
	
}
