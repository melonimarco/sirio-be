package com.accenture.sirio.entityTO;

import java.util.List;

import com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO;

public class ListParchiTO {
	private List<ParcoNaturaleCompletoRTO> listParchi;

	public List<ParcoNaturaleCompletoRTO> getListParchi() {
		return listParchi;
	}

	public void setListParchi(List<ParcoNaturaleCompletoRTO> listParchi) {
		this.listParchi = listParchi;
	}

	@Override
	public String toString() {
		return "ListParchiTO [listParchi=" + listParchi + "]";
	}
	
	
	
}
