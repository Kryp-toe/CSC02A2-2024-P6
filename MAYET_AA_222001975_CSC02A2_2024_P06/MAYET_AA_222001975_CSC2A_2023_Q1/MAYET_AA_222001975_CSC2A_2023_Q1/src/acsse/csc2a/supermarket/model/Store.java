package acsse.csc2a.supermarket.model;

import java.util.ArrayList;

/**
 * 
 */
public class Store {
	
	private ArrayList<Food> foods = new ArrayList<Food>();

	//add to list
	public void AddToFoods(Food food) {
		foods.add(food);
	}
	
	//get from list
	public ArrayList<Food> GetList() {
		return foods;
	}
}
