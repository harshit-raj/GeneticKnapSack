package com.GeneAlgo.KnapSack.AlgoService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.GeneAlgo.KnapSack.Entity.AlgoControls;


public class newMain {
	Generation generation= Generation.getInstance();
	static int runCount = 100;

	
	void setUp() {
		ItemList il = ItemList.getInstance();
		Population firstPop = new Population();
		firstPop.setGenId(0);
		generation.getPopList().add(firstPop);		
	}
	public Generation customSetup(AlgoControls algoCon) {
		Gene.knapsackWeight = algoCon.getKnapSackWeight();
		ItemList.size = algoCon.getItemCount();
		Population.popSize = algoCon.getPopulationSize();
		this.runCount = algoCon.getGenRunCount();
		return returnMain();
	}
	
	void draw() {
		GeneBreeder geneBreeder = new GeneBreederImpl4();
		printPop(generation.getPopList().get(0));
		for(int i = 1; i < runCount; i++) {			
			Population currentPop = geneBreeder.breed(generation.getPopList().get(i-1));
			currentPop.setGenId(i);
			generation.getPopList().add(currentPop);
			//printPop(generation.getPopList().get(i));
		}

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
		}
		System.out.print("Generation " + population.getGenId());
		System.out.print(" | Best gene: " + population.getBestGene());
		System.out.print("Average fitness: " + population.getAveFitness());
		System.out.println(" | Total fitness: " + population.getTotalFitness());
	}
	public Generation returnMain() {
		this.generation.popList.clear();
		newMain newMain = new newMain();
		newMain.setUp();	
		newMain.draw();
		return this.generation;
	}

}
