package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Population {
	private List<Gene> gene = new ArrayList<Gene>();
	static int popSize = 100;
	private int genId;
	private Gene bestGene = null;
	private double totalFitness = -1;

	public Population() {
		 for(int i = 0; i< popSize;i++) {
			 gene.add(new Gene());
		 }
		 
	}

	public List<Gene> getGene() {
		return gene;
	}

	public void setGene(List<Gene> gene) {
		this.gene = gene;
	}

	public static int getPopSize() {
		return popSize;
	}

	public static void setPopSize(int popSize) {
		Population.popSize = popSize;
	}

	public int getGenId() {
		return genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	public Gene getBestGene() {
		if (this.bestGene == null) {
			setBestGene();
		}
		return bestGene;
	}
	
	

	public void setBestGene() {
		double worldRecord = 0;
		int index = 0;
		for(int i = 0; i < popSize; i++) {
			if(gene.get(i).fitness > worldRecord) {
				index = i;
				worldRecord = gene.get(i).fitness;
			}
		}
		this.bestGene = gene.get(index);
	}
	
	public String toString() {
		String res = "";
		for(Gene g: gene) {
			res += g.toString();
			res += " ";
		}
		return res;
	}

	public double getTotalFitness() {
		if(this.totalFitness == -1) {
			setTotalFitness();
		}
		return totalFitness;
	}

	public void setTotalFitness() {
		int fit = 0;
		for(Gene g: gene) {
			fit += g.getFitness();
		}
		this.totalFitness = fit;
	}
	
	

}
