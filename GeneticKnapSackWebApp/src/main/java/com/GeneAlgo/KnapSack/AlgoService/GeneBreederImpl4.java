package com.GeneAlgo.KnapSack.AlgoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneBreederImpl4 implements GeneBreeder {

	@Override
	public Population breed(Population population) {
		List<Gene> childList = new ArrayList<>();
		for(int i = 0; i < Population.popSize; i++) {
			Gene parentA = pickStrategy(population);
			Gene parentB = pickStrategy(population);
			Gene child = crossover(parentA, parentB);
			mutate(0.01, child);
			child.setFitness();
			childList.add(child);
		}
		Population newPop = new Population(childList);
		return newPop;
	}

	@Override
	public Gene crossover(Gene a, Gene b) {
		int midPoint = ItemList.size/2;
		Gene child = new Gene();
		
		for(int i = 0; i < ItemList.size; i++) {
			if(i < midPoint) {
				child.geneAr[i] = a.geneAr[i];
			}else {
				child.geneAr[i] = b.geneAr[i];
			}
		}
		return child;
	}

	@Override
	public void mutate(double mutationRate, Gene child) {
		for(int i = 0; i < child.geneAr.length; i++) {
			if(Math.random() < mutationRate) {
				child.geneAr[i] = Math.random() > 0.5 ? 0:1;
			}
		}
	}

	@Override
	public Gene pickStrategy(Population population) {
		int index = 0;
		Random random = new Random();
		double r = random.nextDouble()*population.getTotalFitness();
		while(r > 0) {
			r = r - population.getGene().get(index).getFitness();
			index++;
		}
		index--;
		return population.getGene().get(index);
	}

	@Override
	public void cull(Population population) {
		// TODO Auto-generated method stub
	}

}
