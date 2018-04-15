package filehandler;

import com.genetic.knapsack.Gene;
import com.genetic.knapsack.Item;
import com.genetic.knapsack.ItemList;
import com.genetic.knapsack.Population;

public class CSVData {
	private int generationNum;
	private double bestGeneFitness;
	private double aveFitness;
	private Gene bestGene;
	private ItemList itemList;
	
	
	public CSVData() {
		
	}
	
	public CSVData(Population population,ItemList itemList) {
		
		this.generationNum = population.getGenId();
		this.bestGene = population.getBestGene();
		this.bestGeneFitness = bestGene.getFitness();
		this.aveFitness = population.getAveFitness();
		this.itemList = itemList;
				
	}
	
	@Override
	public String toString() {
		String result = "";
		result += generationNum;
		for(int i: bestGene.getGeneAr()) {
			result += ",";
			result += i;
			
		}
		result += ",";
		result += bestGeneFitness; 
		result += ",";
		result += aveFitness;
		return result;
	}

	public String toFile() {
		String result = "";
		result += generationNum;
		for(int i: bestGene.getGeneAr()) {
			result += ",";
			result += i;
		}
		result += ",";
		result += bestGeneFitness; 
		result += ",";
		result += aveFitness;
		result += "\n";
		return result;

	}
	
	public String colName() {
		String result = "";
		
		result += "Item Value";

		for(Item i: itemList.getItemList()) {
			result +=",";
			result += i.getValue();
		}
		result += ",";
		result += " "; 
		result += ",";
		result += " ";
		result += "\n";
		
		result += "Item Weight";

		for(Item i: itemList.getItemList()) {
			result +=",";
			result += i.getWeight();
		}
		result += ",";
		result += " "; 
		result += ",";
		result += " ";
		result += "\n";
		
		
		result += "Gen num";
		for(int i: bestGene.getGeneAr()) {
			result += ",";
			result += " ";
		}
		result += ",";
		result += "Best Gene Fitness"; 
		result += ",";
		result += "Average Fitness";
		result += "\n";
		
		return result;
	}

}
