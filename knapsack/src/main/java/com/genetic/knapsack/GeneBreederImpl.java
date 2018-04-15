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
	
	private void setProb(Population population) {
		double sum = 0;
		for(int i = 0; i < population.getGene().size(); i++) {
			sum += population.getGene().get(i).fitness;
		}		
		for(int i = 0; i < population.getGene().size(); i++) {
			double prob = population.getGene().get(i).fitness/sum;
			population.getGene().get(i).setProb(prob);
		}
	}

	public Gene pickStrategy(Population population) {
		int index = 0;
		double r = Math.random();
		while(r > 0) {
			r = r - population.getGene().get(index).getProb();
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

	public void breed(Population population, int generationNum) {
//		System.out.println("------------------------------------------------------");
		Population newPop = new Population();
		List<Gene> childList = new ArrayList<Gene>();
		setProb(population);
		for(int i = 0; i < Population.getPopSize(); i++) {
			Gene parentA = pickStrategy(population);
			Gene parentB = pickStrategy(population);
			Gene child = crossover(parentA, parentB);
			mutate(mutationRate, child);
			childList.add(child);
//			System.out.println("Child #" + i + " fitness: " + child.fitness);
		}		
		generation.getPopList().add(newPop);
		newPop.setGene(childList);
		newPop.setGenId(population.getGenId()+1);
//		System.out.println("best fitness is: " + newPop.getBestGene().fitness + "========================");
		if(population.getGenId() > generationNum-2) {
			return;
		}else {					
			breed(newPop, generationNum);	
		}	
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
