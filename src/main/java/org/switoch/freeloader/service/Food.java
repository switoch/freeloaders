package org.switoch.freeloader.service;

/**
 * Keeping of food's properties
 */
public class Food {

	private String foodType;
	private String petType;
	private int count;

	public Food(String foodType, String petType, int count) {
		super();
		this.foodType = foodType;
		this.petType = petType;
		this.count = count;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
