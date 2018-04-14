package com.genetic.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemList {
	List<Item> itemList= new ArrayList<Item>();
	static int size = 100;
	static Random random = new Random(0);
	static ItemList instance = null;

	private ItemList() {
		for(int i = 0; i < size;i++) {
			Item item = new Item();
			item.setValue(1+(100-1)*random.nextDouble());
			item.setWeight(10+(1000-10)*random.nextDouble());
		}
	}
	
	static ItemList getInstance() {
		if (instance == null) {
			instance = new ItemList();
		}
		return instance;
	}
	

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	public String toString() {
		String st = "";
		for(Item i : itemList) {
			st += i.toString();
			st += " ";
		}
		return st;
	}
	
	
	
	

}
