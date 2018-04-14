package com.genetic.knapsack;

public interface GeneBreeder {
	public void breed();
	public Gene crossover(Gene a, Gene b);
	public void mutate(double mutationRate, Gene gene);
	public Gene pickStrategy(Population population);
	public void cull(Population population);

}
