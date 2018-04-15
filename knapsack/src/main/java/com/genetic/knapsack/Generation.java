package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Generation {
	List<Population> popList = new ArrayList<Population>();
	static Generation instance = null;

	private Generation() {
					
	}
	
	static Generation getInstance() {
		if (instance == null) {
			instance = new Generation();
		}
		return instance;
	}

	public List<Population> getPopList() {
		return popList;
	}


	public void setPopList(List<Population> popList) {
		this.popList = popList;
	}
	
	

}
