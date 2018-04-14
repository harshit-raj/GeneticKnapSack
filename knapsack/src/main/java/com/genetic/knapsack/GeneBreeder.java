package com.genetic.knapsack;

public interface GeneBreeder {
	public Gene crossover(Gene a, Gene b);
	public void mutate(Gene gene);
	public Gene pickStrategy(Population population);
	public void cull(Population population);

}
