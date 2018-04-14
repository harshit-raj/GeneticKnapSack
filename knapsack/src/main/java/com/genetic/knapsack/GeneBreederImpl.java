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
	List<Gene> childList = new ArrayList<Gene>();
	int numberofChild = 4;
	Population population = new Population();
	double mutationRate = 0.01;	
	
		public GeneBreederImpl(Population population) {
			cull(population);
			this.population = population;
		}

		public Gene crossover(Gene a, Gene b) {
			// A new child
			Gene child = new Gene();
			int midpoint = (int) (Math.random()*genePQ.size());
			
			//Half from one, half from another
			for(int i = 0; i < genePQ.size(); i++) {
				if(i > midpoint) {
					child.geneAr[i] = a.geneAr[i];
				}else {
					child.geneAr[i] = b.geneAr[i];
				}
			}
			return child;
		}

		public void mutate(double mutationRate, Gene gene) {
			for(int i = 0; i < gene.geneAr.length; i++) {
				if(Math.random() < mutationRate) {
					gene.geneAr[i] = Math.random()>0.5?0:1;
				}
			}
		}
		
		private void setProb() {
			double sum = 0;
			for(int i = 0; i < population.getGene().size(); i++) {
				sum += population.getGene().get(i).fitness;
			}
			for(int i = 0; i < population.getGene().size(); i++) {
				population.getGene().get(i).setProb(population.getGene().get(i).fitness/sum);
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
			return population.getGene().get(index);
		}

		public void cull(Population population) {
			genePQ = new PriorityQueue<Gene>(population.getPopSize()/2, Collections.reverseOrder());
			genePQ.addAll(population.getGene());
			
		}

		public void breed() {
			Gene[] ga = (Gene[]) genePQ.toArray();
			Arrays.sort(ga, Collections.reverseOrder());	
			
			setProb();
			for(int i = 0; i < numberofChild; i++) {
				Gene child = generate();
				childList.add(child);
			}
			//pick parent 1
			//pick parent 2
			//child 1 (1,2)
			//mutate
			//save
			//child 2 (2,1)
			//child 3 (1,2)
			//child 4 (2,1)
		}
		
		//Gene 
		
		private Gene generate() {
			Gene parentA = pickStrategy(population);
			Gene parentB = pickStrategy(population);
			Gene child = crossover(parentA, parentB);
			mutate(mutationRate, child);
			return child;
		}
	
	

}
