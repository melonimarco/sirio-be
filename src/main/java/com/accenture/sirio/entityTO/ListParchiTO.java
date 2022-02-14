package com.accenture.sirio.entityTO;

import java.util.List;

public class ListParchiTO {
	private List<ParcoNaturaleTO> listParchi;

	public List<ParcoNaturaleTO> getListParchi() {
		return listParchi;
	}

	public void setListParchi(List<ParcoNaturaleTO> listParchi) {
		this.listParchi = listParchi;
	}

	@Override
	public String toString() {
		return "ListParchiTO [listParchi=" + listParchi + "]";
	}
	
	
	
}
