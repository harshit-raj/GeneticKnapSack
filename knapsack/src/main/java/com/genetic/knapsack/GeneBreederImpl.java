package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class GeneBreederImpl implements GeneBreeder{
	PriorityQueue<Gene> genePQ;
	Population population = new Population();
	double mutationRate = 0.01;	
	int childNum = 4;
	Generation generation = Generation.getInstance();
	
	public GeneBreederImpl(Population population) {
		cull(population);
		this.population = population;
	}

	public Gene crossover(Gene a, Gene b) {
		// A new child
		Gene child = new Gene();
		int midpoint = (int) (Math.random()*Population.popSize);
		
		//Half from one, half from another
		for(int i = 0; i < Population.popSize; i++) {
			if(i > midpoint) {
				child.geneAr[i] = a.geneAr[i];
			}else {
				child.geneAr[i] = b.geneAr[i];
			}
		}
//		System.out.println("parent A: " + a.fitness + " parent B: " + b.fitness + " child: " + child.fitness);
		return child;
	}

	public void mutate(double mutationRate, Gene child) {
		for(int i = 0; i < child.geneAr.length; i++) {
			if(Math.random() < mutationRate) {
//				System.out.print("mutation happens, change " + child.geneAr[i] + " to ");
				child.geneAr[i] = Math.random()>0.5?0:1;
//				System.out.println(child.geneAr[i] + " for child at index " + i);
			}
		}
	}

	public Gene pickStrategy(Population population) {
		int index = 0;
		Random random = new Random();
		double r = random.nextDouble()*population.getBestGene().getFitness();
		while(r > 0) {
			r = r - population.getGene().get(index).getFitness();
			index++;
		}
		index--;
//		System.out.println("picked parent with fitness: " + population.getGene().get(index).fitness + " out of " + population.getBestGene().fitness);
		return population.getGene().get(index);
	}

	public void cull(Population population) {
		genePQ = new PriorityQueue<Gene>(Population.getPopSize()/2, Collections.reverseOrder());
		genePQ.addAll(population.getGene());
		
	}

	public Population breed(Population population) {
//		System.out.println("------------------------------------------------------");
		
//		Population newPop = new Population();
		List<Gene> childList = new ArrayList<Gene>();
//		setProb(population);
//		for(int i = 0; i < genePQ.size(); i++) {
//			for(int j=0; j < childNum; j++) {
//				Gene parentA = pickStrategy(population);
//				Gene parentB = pickStrategy(population);
//				Gene child = crossover(parentA, parentB);
//				mutate(mutationRate, child);
//				childList.add(child);
//			}			
////			System.out.println("Child #" + i + " fitness: " + child.fitness);
//		}
		for(int i = 0; i < Population.getPopSize(); i++) {
			Gene parentA = pickStrategy(population);
			Gene parentB = pickStrategy(population);
			Gene child = crossover(parentA, parentB);
			mutate(mutationRate, child);
			childList.add(child);			
//			System.out.println("Child #" + i + " fitness: " + child.fitness);
		}
		Population newPop = new Population(childList);
//		System.out.println("best fitness is: " + newPop.getBestGene().fitness + "========================");
		return newPop;
	}
	
	//Gene 
	
//	private Gene generate(Population population) {
//		Gene parentA = pickStrategy(population);
//		Gene parentB = pickStrategy(population);
//		Gene child = crossover(parentA, parentB);
//		mutate(mutationRate, child);
//		return child;
//	}

	

}
