package com.genetic.knapsack;

import java.util.List;

import org.apache.log4j.Logger;

public class Gene implements Comparable<Gene>{
	static Logger log = Logger.getLogger(Gene.class.getName());

	int[] geneAr;
	int length = ItemList.size;
	double fitness = -1;
	static double knapsackWeight = 50000;
	//static Random random = new Random();
	public Gene() {
		super();
		geneAr = new int[length];
		for(int i = 0; i<length;i++) {
			geneAr[i]=(Math.random()>0.5?0:1);
		}		
	}




	public Gene(Gene g) {
		super();
		this.geneAr = g.geneAr;
		this.length = g.length;
		this.fitness = g.fitness;
	}




	public int[] getGeneAr() {
		return geneAr;
	}
	public void setGeneAr(int[] geneAr) {
		this.geneAr = geneAr;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getFitness() {
//		if(fitness == -1) {
//			setFitness();
//		}
		return fitness;
	}
	public void setFitness() {
	    log.info("setFitness() method." + "fitness is " + fitness);
		List<Item> items = ItemList.getInstance().getItemList();
		double weight = 0;
		for(int i = 0; i < items.size(); i++) {
			if(geneAr[i] == 1) {
				fitness += items.get(i).getValue();
//				System.out.println("item " + i + ", weight: " + items.get(i).getWeight() + ", value: " + items.get(i).getValue());
				weight += items.get(i).getWeight();
			}
		}
		if(weight > knapsackWeight) {
			this.fitness = 0;
		}else {
			this.fitness = Math.pow(fitness, 2);
		}
//		System.out.println("weight is " + weight);
//		System.out.println("fitness is " + fitness);
	}




	public int compareTo(Gene gene) {
		if(this.fitness==gene.fitness)
			return 0;
		else if(this.fitness>gene.fitness)
			return 1;
		else
			return -1;
	}


	public String toString() {
		String res = "[";
		for(int i : geneAr) {
			res += i;
		}
		res+= "] ";
		res+= getFitness();
		res+=" | ";

		return res;
	}

}