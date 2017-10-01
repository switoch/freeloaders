package org.switoch.freeloader.domain;

import java.util.List;

/**
 * Responsible for the keeping of {@link Food} instances.
 */
public class Storage {

	public static final int MAX_FOOD_AMMOUNT = 10;

	private List<Food> foods;

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

}
