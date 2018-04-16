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

	@Override
	public String toString() {
		String result = "";
		for(Population population : popList) {
			//result+=population.toString();
			result+=population.getGenId();
			result+=" Average Fitness ";
			result+=population.getAveFitness();
			result+=" Best gene ";
			result+=population.getBestGene().toString();
			result+="\n";
		}
		return result;
	}
	
	

}
