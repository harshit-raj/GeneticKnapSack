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

public class GeneBreederImpl2 implements GeneBreeder{
	List<Gene> forBreed = new ArrayList<Gene>();
	static int cullFactor = 8;
	double totalBreedFitness = 0;
	Random random = new Random();

	@Override
	public Population breed(Population population) {
		cull(population);
		int l = forBreed.size();
		List<Gene> childList= new ArrayList<Gene>();
//		for(int i=0; i< Population.popSize; i++) {
//			Gene mom = forBreed.get((int) (Math.random()*l));
////			System.out.print("Mom "+ mom.getFitness());
//			Gene dad = forBreed.get((int) (Math.random()*l));
////			System.out.println(" Dad "+ dad+ dad.getFitness());
//			Gene baby = crossover(dad, mom);
////			System.out.println("Baby "+ baby +baby.getFitness());
//			childList.add(baby);
//		}
		for(int i=0; i< Population.popSize; i++) {
			Gene mom = pickStrategy();	
			Gene dad = pickStrategy();
			System.out.println("mom fitness / pop fitness" + mom.getFitness()/population.getTotalFitness());
			if(mom.getFitness()/population.getTotalFitness() > 0.2) {
				mutate(0.01, mom);
				childList.add(mom);
			}else {
				Gene baby1 = crossover(mom, dad);
				Gene baby2 = crossover(dad, mom);
				childList.add(baby1);
				childList.add(baby2);
				i++;
			}
//			System.out.print("Mom "+ mom.getFitness());
//			Gene dad = pickStrategy();
//			System.out.println(" Dad "+ dad+ dad.getFitness());
//			Gene baby = crossover(dad, mom);
//			System.out.println("Baby "+ baby +baby.getFitness());
			
		}
//		for(int i=0; i< Population.popSize; i++) {
//			Gene mom = pickStrategy();
//			if(mom.getFitness()/population.getAveFitness()> 0.9) {
//				if(Math.random()>0.5) {
//					childList.add(mom);
//					continue;
//				}
//				else {
//					mutate(0.3, mom);
//					childList.add(mom);
//					continue;
//				}
//			}
//			
////			System.out.print("Mom "+ mom.getFitness());
//			Gene dad = pickStrategy();
////			System.out.println(" Dad "+ dad+ dad.getFitness());
//			Gene baby = crossover(dad, mom);
////			System.out.println("Baby "+ baby +baby.getFitness());
//			childList.add(baby);
//		}

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
	
	@Override
	public Gene crossover(Gene a, Gene b) {
		Gene child = new Gene();
//		int firstCut = ItemList.size/3;
//		int secondCut = ItemList.size/3*2;
		int midPoint = ItemList.size/2;
//		System.out.println("mid "+ midpoint);
		
		//Half from one, half from another
		for(int i = 0; i < ItemList.size; i++) {
			if(i < midPoint) {
				child.geneAr[i] = a.geneAr[i];
			}else {
				child.geneAr[i] = b.geneAr[i];
			}
			mutate(0.01, child);
		}
		return child;

	}

	@Override
	public void mutate(double mutationRate, Gene child) {
		for(int i = 0; i < child.geneAr.length; i++) {
			if(Math.random() < mutationRate) {
				//System.out.println("Mutating at "+ i);
				//System.out.print("mutation happens, change " + child.geneAr[i] + " to ");
				child.geneAr[i] = Math.random()>0.5?0:1;
				//System.out.println(child.geneAr[i] + " for child at index " + i);
			}
		}

	}

	@Override
	public void cull(Population population) {

/*		System.out.println("Population");
		System.out.println(population.toString());
*/
		Collections.sort(population.getGene());


		for(int i = population.getGene().size()-1; i > population.getGene().size()/cullFactor;i--) {
			forBreed.add(population.getGene().get(i));
			totalBreedFitness += population.getGene().get(i).getFitness();
		}
//		System.out.println("New gene");
/*		for(Gene g: forBreed) {
			System.out.print(g+" "+g.getFitness()+"  ");
		}
*///		System.out.println();
	}

	public Gene pickStrategy() {
		int index = 0;
		double r = random.nextDouble()*totalBreedFitness;
//		System.out.println("R "+ r);
		while(r > 0) {
			r = r - forBreed.get(index).getFitness();
			index++;
		}
		index--;
//		System.out.println(index);
//		if(index<0) index = 0;
//		System.out.println("picked parent with fitness: " + population.getGene().get(index).fitness + " out of " + population.getBestGene().fitness);
		return forBreed.get(index);
	}

	@Override
	public Gene pickStrategy(Population population) {
		// TODO Auto-generated method stub
		return null;
	}

}
