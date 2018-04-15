package com.genetic.knapsack;

public class newMain {
	Generation generation= Generation.getInstance();
//	void setUp() {
//		ItemList il = ItemList.getInstance();
////		Population.popSize= 100;
//		Population firstPopulation = new Population();
//		firstPopulation.setGenId(0);
//		generation.getPopList().add(firstPopulation);
//		System.out.println(firstPopulation);
//		GeneBreeder geneBreeder = new GeneBreederImpl2();
////		GeneBreederImpl3 geneBreeder = new GeneBreederImpl3();		
//		//Population nextPopulation= geneBreeder.breed(firstPopulation);
//		for(int i = 1;i <100;i++) {
//			Population pop = geneBreeder.breed(generation.getPopList().get(i-1));
//			pop.setGenId(i);
//			generation.getPopList().add(pop);
////			System.out.println(generation.getPopList().get(i).getBestGene());
//			
//		}
//		
////		generation.getPopList().add(geneBreeder.breed(firstPopulation));
//		System.out.println(generation.toString());
//	}
	
	void setUp() {
		ItemList il = ItemList.getInstance();
		Population firstPop = new Population();
		firstPop.setGenId(0);
		generation.getPopList().add(firstPop);		
	}
	
	void draw() {
		GeneBreeder geneBreeder = new GeneBreederImpl4();
		printPop(generation.getPopList().get(0));
		for(int i = 1; i < 100; i++) {			
			Population currentPop = geneBreeder.breed(generation.getPopList().get(i-1));
			currentPop.setGenId(i);
			generation.getPopList().add(currentPop);
			printPop(generation.getPopList().get(i));
		}
//		System.out.println(generation.toString());
	}
	
	void itemList() {
		ItemList il = ItemList.getInstance();
		int i = 0;
		for(Item item:il.getItemList()) {
			System.out.println("item " + i + ", weight: " + item.getWeight() + ", value: " + item.getValue());
			i++;
		}
	}
	
	void printPop(Population population) {
		ItemList il = ItemList.getInstance();
		for(Gene gene: population.getGene()) {
//			System.out.println(gene);
		}
		System.out.print("Generation " + population.getGenId());
		System.out.print(" | Best gene: " + population.getBestGene());
		System.out.print("Average fitness: " + population.getAveFitness());
		System.out.println(" | Total fitness: " + population.getTotalFitness());
	}
	public static void main(String[] args) {
		newMain newMain = new newMain();
//		newMain.itemList();
		newMain.setUp();		
//		newMain.firstPop();
		newMain.draw();
	}
}
