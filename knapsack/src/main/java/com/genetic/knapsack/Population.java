package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Population {
	private List<Gene> gene = new ArrayList<Gene>();
	static int popSize = 5;
	private int genId;
	private Gene bestGene = null;
	private double totalFitness = -1;
	private double aveFitness = -1;



	public Population() {
		for(int i = 0; i< popSize;i++) {
			Gene newGene = new Gene();
			newGene.setFitness();
			this.gene.add(newGene);
		}
		setTotalFitness();
		setAveFitness();
		setBestGene();
		//setProb();
	}

	public Population(List<Gene> geneList) {
		this.gene = geneList;
		setTotalFitness();
		setAveFitness();
		setBestGene();
		//setProb();
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
//		if (this.bestGene == null) {
//			setBestGene();
//		}
		return bestGene;
	}



	public void setBestGene() {
		double worldRecord = 0;
		int index = 0;
		for(int i = 0; i < popSize; i++) {
			if(gene.get(i).getFitness() > worldRecord) {
				index = i;
				worldRecord = gene.get(i).getFitness();
			}
		}
		this.bestGene = gene.get(index);
	}

	public String toString() {
		String res = "";
		for(Gene g: gene) {
			res += g.toString();
			res += " ";
			res+= g.getFitness();
			res+= "||";
		}
		return res;
	}

	public double getTotalFitness() {
//		if(this.totalFitness == -1) {
//			setTotalFitness();
//		}
		return totalFitness;
	}

	public void setTotalFitness() {
		int fit = 0;
		for(Gene g: gene) {
			fit += g.getFitness();
		}
		this.totalFitness = fit;
	}

	public double getAveFitness() {
//		if(this.aveFitness == -1) {
//			setAveFitness();
//		}
		return aveFitness;
	}

	public void setAveFitness() {
		this.aveFitness = getTotalFitness()/popSize;
	}
	
//	private void setProb() {
//		double sum = 0;
//		for(int i = 0; i < gene.size(); i++) {
//			sum += gene.get(i).getFitness();
//		}		
////		System.out.println("sum is " + sum + "---------------------");
//		for(int i = 0; i < gene.size(); i++) {
////			System.out.println(gene.get(i).getFitness());
//			double prob = gene.get(i).getFitness()/sum;
//			gene.get(i).setProb(prob);
////			System.out.println("Prob is: " + prob);
//		}
//	}



}
