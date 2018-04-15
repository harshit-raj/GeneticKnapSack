package com.genetic.knapsack;

public class KnapSackMain {
	Population population;
	static Generation generation;
	
	public KnapSackMain() {
		// TODO Auto-generated constructor stub
		
		//initialize first population
		
		//breed
		//display best from new generation 
	}
	
	void setUp() {
		ItemList il = ItemList.getInstance();
		Population.popSize= 10;
		population = new Population();
		generation = Generation.getInstance();
		population.setGenId(0);
		generation.getPopList().add(population);
	}
	
	void draw() {
		GeneBreeder geneBreeder = new GeneBreederImpl(population);
		geneBreeder.breed(population,100);		
	}
	
	public static void main(String[] args) {
		KnapSackMain knapSackMain = new KnapSackMain();
		knapSackMain.setUp();
		knapSackMain.draw();
		for(Population pop:generation.getPopList()) {
			System.out.print("best gene in generation " +  pop.getGenId() + " is " + pop.getBestGene() + " with fitness: " + pop.getBestGene().fitness);
			System.out.println(" and ave fitness: " + pop.getAveFitness());
		}
		
	}

}
