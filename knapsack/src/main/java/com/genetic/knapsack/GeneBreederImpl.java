package com.genetic.knapsack;

import java.util.PriorityQueue;

public class GeneBreederImpl implements GeneBreeder{
	PriorityQueue<Gene> GenePQ;
			
		public GeneBreederImpl(Population population) {
			cull(population);
		}

		public Gene crossover(Gene a, Gene b) {
			// TODO Auto-generated method stub
			return null;
		}

		public void mutate(Gene gene) {
			// TODO Auto-generated method stub
			
		}

		public Gene pickStrategy(Population population) {
			// TODO Auto-generated method stub
			return null;
		}

		public void cull(Population population) {
			GenePQ = new PriorityQueue<Gene>(population.getPopSize()/2);
			
		}
	
	
	

}
