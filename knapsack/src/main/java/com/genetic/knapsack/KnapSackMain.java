package com.genetic.knapsack;

public class KnapSackMain {

	public KnapSackMain() {
		// TODO Auto-generated constructor stub
		
		//initialize first population
		
		//breed
		//display best from new generation 
	}
	
	public static void main(String[] args) {
		ItemList il = ItemList.getInstance();
		Population.popSize= 10;
		Population pop = new Population();
		System.out.println(pop);
		System.out.print("Fitness ");
		System.out.println(pop.getGene().get(0).fitness);
		System.out.println("Done");
	}

}
