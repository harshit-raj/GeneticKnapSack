package com.genetic.knapsack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.*;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnapSackTest {

	GeneBreeder geneBreeder = new GeneBreederImpl4();
	Population population;
	ItemList itemList = ItemList.getInstance();


	@Before 
	public  void setup() throws Exception {
		Gene.knapsackWeight=100000;
		Gene gene1=new Gene();
		gene1.setGeneAr(new int[]{ 1, 0, 0, 1, 1, 0, 0, 1, 1, 0 });
		gene1.setFitness();


		Gene gene2=new Gene();
		gene2.setGeneAr(new int[]{ 1, 1, 0, 0, 0, 1, 0, 1, 0, 0 });
		gene2.setFitness();

		Gene gene3=new Gene();
		gene3.setGeneAr(new int[]{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 });
		gene3.setFitness();

		Gene gene4=new Gene();
		gene4.setGeneAr(new int[]{ 1, 0, 0, 1, 1, 1, 0, 1, 1, 0 });
		gene4.setFitness();

		Gene gene5=new Gene();
		gene5.setGeneAr(new int[]{ 1, 0, 1, 1, 0, 1, 0, 0, 0, 0 });
		gene5.setFitness();

		List<Gene> geneList = new ArrayList<Gene>();

		geneList.add(gene1);
		geneList.add(gene2);
		geneList.add(gene3);
		geneList.add(gene4);
		geneList.add(gene5);
		population=new Population(geneList);
	}


	@Test
	public void testPopulationFitness() {
		population.setAveFitness();
		assertTrue(population.getAveFitness()==53827.6);
		}

	@Test
	public void testGetBestGene() {
		Gene bestGeneOfPopulation = population.getBestGene();
		assertArrayEquals(bestGeneOfPopulation.getGeneAr(),new int[]{ 1, 0, 0, 1, 1, 1, 0, 1, 1, 0 });
		}
	

	@Test
	public void testCrossover() throws Exception {
		Gene momGene = new Gene();  // {1, 0, 1, 1, 0, 1, 0, 0, 0, 0}
		Gene dadGene = new Gene();	//{1, 1, 1, 0, 0, 1, 0, 1, 1, 1}

		momGene.setGeneAr(new int[]{1, 0, 1, 1, 0, 1, 0, 0, 0, 0});		
		dadGene.setGeneAr(new int[]{1, 1, 1, 0, 0, 1, 0, 1, 1, 1});

		Gene babyGene = geneBreeder.crossover(momGene, dadGene);

		assertArrayEquals(babyGene.getGeneAr(),new int[]{ 1, 0, 1, 1, 0, 1, 0, 1, 1, 1} );

	}

	@Test
	public void testMutate() {
		Gene gene=new Gene();
		gene.setGeneAr(new int[]{ 1, 0, 0, 1, 1, 0, 0, 1, 1, 0 });

		Gene mutatedGene=new Gene(gene);
		geneBreeder.mutate(0.5, mutatedGene);
		Assert.assertThat(gene, IsNot.not(IsEqual.equalTo(mutatedGene)));
	}



}
