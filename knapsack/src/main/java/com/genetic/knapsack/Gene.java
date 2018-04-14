package com.genetic.knapsack;

import java.util.List;
import java.util.Random;

public class Gene implements Comparable<Gene>{
	int[] geneAr;
	int length = ItemList.size;
	double fitness = 0;
	static double knapsackWeight = 10000;
	//static Random random = new Random();
	public Gene() {
		super();
		geneAr = new int[length];
		for(int i = 0; i<length;i++) {
			geneAr[i]=(Math.random()>0.5?0:1);
		}
		setFitness();	

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
		return fitness;
	}
	public void setFitness() {
		List<Item> items = ItemList.getInstance().getItemList();
		double weight = 0;

		for(int i = 0; i < length; i++) {

			if(geneAr[i] == 1) {

				fitness += items.get(i).getValue();
				weight += items.get(i).getWeight();
			}
		}
		if(weight > knapsackWeight) this.fitness = 0;
		fitness /= ItemList.getInstance().getTotalVal();
		fitness *= 100;
		this.fitness = Math.pow(fitness, 2);
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
			res += " ";
		}
		res+= "]";
		
		return res;
	}






}