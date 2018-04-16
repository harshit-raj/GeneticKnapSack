package com.GeneAlgo.KnapSack.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class AlgoControls {
	
	double knapSackWeight;
	int itemCount;
	int populationSize;
	int genRunCount;
	public double getKnapSackWeight() {
		return knapSackWeight;
	}
	public void setKnapSackWeight(double knapSackWeight) {
		this.knapSackWeight = knapSackWeight;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getPopulationSize() {
		return populationSize;
	}
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
	public int getGenRunCount() {
		return genRunCount;
	}
	public void setGenRunCount(int genRunCount) {
		this.genRunCount = genRunCount;
	}
	public AlgoControls() {
		
	}
	public AlgoControls(double knapSackWeight, int itemCount, int populationSize, int genRunCount) {
		super();
		this.knapSackWeight = knapSackWeight;
		this.itemCount = itemCount;
		this.populationSize = populationSize;
		this.genRunCount = genRunCount;
	}
	
	public AlgoControls(double knapSackWeight, int itemCount, int populationSize) {
		super();
		this.knapSackWeight = knapSackWeight;
		this.itemCount = itemCount;
		this.populationSize = populationSize;
		this.genRunCount = 100000;
	}
	
	
	

}
