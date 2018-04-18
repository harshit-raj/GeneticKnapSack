# GeneticKnapSack - Team 333 
> ###### Fudi Liu 
> ###### Harshit Raj 
> ###### Meghana Srinivasa

To submission has two projects a 
 -  **Java Application** 
 -  **Java Web App**

###### Problem Definition
The Knapsack Problem (KP) is a combinatorial optimization, which seeks for a best solution from a pool of solutions. In this particular KP problem, there are a set of distinct items with randomized weight and value, and the knapsack has a limited weight capacity. A solution is encoded into an array of binaries indicating items selected (1s) and items not selected (0s). Abetter solution selects items with as high value as possible to put into the knapsack without exceeding the weight capacity. Genetic Algorithm is considered to be a sound methodology in finding one of the optimal solutions for KP problems. By initializing, selecting, and reproducing, the solution pool evolves and gives better results at each generation. This report intends to introduce the implementations, observations, and results of this Genetic Algorithm project.


###### Fitness Function
The fitness of a gene is evaluated based on the items selected. We first added up all the values of all the items that are selected, then square the sum to give it a larger scale. The equation is f(x)fitness = $(∑ ValueselectedItem)^2$

Selection Strategy: Instead of sorting the genes by its fitness value, we decided that, to reproduce
the next generation, a biased selection strategy should be used. This strategy selects a gene from
the population based on its fitness. Genes with higher fitness values will have higher chance
being selected. Below is an example explaining the details of the implementation.
