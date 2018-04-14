/**
 * 
 */
package com.genetic.knapsack;

/**
 * @author Harshit
 *
 */
public class Item {
	private double weight;
	private double value;
	private String name;
	//private double totalVal;

	/**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Item(double weight, double value,String name) {
		super();
		this.weight = weight;
		this.value = value;
		this.name = name;
	}
	
	public Item(Item item) {
		
		this.weight = item.weight;
		this.value = item.value;
		this.name = item.name;
	}



	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public String toString() {
		return "Value" + this.value + "Weight" + this.weight;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	

}
