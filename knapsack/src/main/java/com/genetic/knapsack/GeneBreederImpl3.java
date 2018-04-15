package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import org.apache.commons.lang.math.DoubleRange;

public class GeneBreederImpl3{
	Population population;
	List<Gene> childList;
	static int cullFactor = 2;
	double totalBreedFitness = 0;
	Random random = new Random();

	public Population breed(Population population) {
		this.population = population;
		//cull(population);
		childList= new ArrayList<Gene>();
//		for(int i=0; i< Population.popSize; i++) {
//			Gene mom = forBreed.get((int) (Math.random()*l));
////			System.out.print("Mom "+ mom.getFitness());
//			Gene dad = forBreed.get((int) (Math.random()*l));
////			System.out.println(" Dad "+ dad+ dad.getFitness());
//			Gene baby = crossover(dad, mom);
////			System.out.println("Baby "+ baby +baby.getFitness());
//			childList.add(baby);
//		}
		for(int i=0; i< Population.popSize; i+=2) {
			Gene mom = pickStrategy();
			System.out.println("got mom" + mom);
		//	if(mom.getFitness()/population.getAveFitness()> Math.random()) {
				if(0.5> Math.random()) {
				if(Math.random()>0.5) {
					childList.add(mom);
					
					
				}
				else {
					mutate(0.3, mom);
					childList.add(mom);
					//childList.add(pickStrategy());
				}
				childList.add(pickStrategy());
				System.out.println("added momwithout crossover");
				continue;
			}
			
//			System.out.print("Mom "+ mom.getFitness());
			Gene dad = pickStrategy();
			
//			System.out.println(" Dad "+ dad+ dad.getFitness());
			crossover(dad, mom);
//			System.out.println("Baby "+ baby +baby.getFitness());
			//childList.add(baby);
		}

		Population nextPopultion= new Population(childList);		
		return nextPopultion;
	}

//	@Override
//	public Gene crossover(Gene a, Gene b) {
//		Gene child = new Gene();
//		int midpoint = (int) (Math.random()*ItemList.size);
////		System.out.println("mid "+ midpoint);
//
//		//Half from one, half from another
//		for(int i = 0; i < ItemList.size; i++) {
//			if(i > midpoint) {
//				child.geneAr[i] = a.geneAr[i];
//			}else {
//				child.geneAr[i] = b.geneAr[i];
//			}
//			mutate(0.01, child);
//		}
//
//		return child;
//
//	}
	
	public void crossover(Gene a, Gene b) {
		
//		int firstCut = ItemList.size/3;
//		int secondCut = ItemList.size/3*2;
		int midPoint = ItemList.size/2;
//		System.out.println("mid "+ midpoint);
		
		//Half from one, half from another
		Gene child1 = new Gene();
		for(int i = 0; i < ItemList.size; i++) {
			
			if(i < midPoint) {
				child1.geneAr[i] = a.geneAr[i];
			}else {
				child1.geneAr[i] = b.geneAr[i];
			}
			mutate(0.01, child1);
		}
		while(child1.getFitness()<=0) {
			mutate(0.3, child1);
		}
		this.childList.add(child1);
		
		Gene child2 = new Gene();
		for(int i = 0; i < ItemList.size; i++) {
			
			if(i > midPoint) {
				child2.geneAr[i] = a.geneAr[i];
			}else {
				child2.geneAr[i] = b.geneAr[i];
			}
			mutate(0.01, child2);
		}
		while(child2.getFitness()<=0) {
			mutate(0.3, child1);
		}

		this.childList.add(child2);

	}

	public void mutate(double mutationRate, Gene child) {
		for(int i = 0; i < child.geneAr.length; i++) {
			if(Math.random() < mutationRate) {
				//System.out.println("Mutating at "+ i);
				//System.out.print("mutation happens, change " + child.geneAr[i] + " to ");
				child.geneAr[i] = Math.random()>0.5?0:1;
				//System.out.println(child.geneAr[i] + " for child at index " + i);
			}
		}
		child.setFitness();

	}

	public void cull(Population population) {

/*		System.out.println("Population");
		System.out.println(population.toString());
*/
		Collections.sort(population.getGene());


		/*for(int i = population.getGene().size()-1; i > population.getGene().size()/cullFactor;i--) {
			forBreed.add(population.getGene().get(i));
			totalBreedFitness += population.getGene().get(i).getFitness();
		}*/
//		System.out.println("New gene");
/*		for(Gene g: forBreed) {
			System.out.print(g+" "+g.getFitness()+"  ");
		}
*///		System.out.println();
	}

	public Gene pickStrategy() {
		int index = 0;
		population.setTotalFitness();
		double r = random.nextDouble()*population.getTotalFitness();
		System.out.println("R "+ r);
		while(r > 0) {
			r = r - population.getGene().get(index).getFitness();
			index++;
		}
		index--;
		System.out.println(index);
		if(index<0) index = 0;
//		System.out.println("picked parent with fitness: " + population.getGene().get(index).fitness + " out of " + population.getBestGene().fitness);
		return population.getGene().get(index);
	}


}
