package com.genetic.knapsack;

public class newMain {
	Generation generation= Generation.getInstance();
	void setUp() {
		ItemList il = ItemList.getInstance();
//		Population.popSize= 100;
		Population firstPopulation = new Population();
		firstPopulation.setGenId(0);
		generation.getPopList().add(firstPopulation);
		System.out.println(firstPopulation);
		GeneBreeder geneBreeder = new GeneBreederImpl2();
//		GeneBreederImpl3 geneBreeder = new GeneBreederImpl3();		
		//Population nextPopulation= geneBreeder.breed(firstPopulation);
		for(int i = 1;i <100000;i++) {
			Population pop = geneBreeder.breed(generation.getPopList().get(i-1));
			pop.setGenId(i);
			generation.getPopList().add(pop);
//			System.out.println(generation.getPopList().get(i).getBestGene());
			
		}
		
//		generation.getPopList().add(geneBreeder.breed(firstPopulation));
		System.out.println(generation.toString());
	}
	public static void main(String[] args) {
		newMain newMain = new newMain();
		newMain.setUp();
	}
}
