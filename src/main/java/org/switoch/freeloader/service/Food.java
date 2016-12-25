package org.switoch.freeloader.service;

/**
 * Keeping of food's properties
 */
public class Food {

	private String foodType;
	private String petType;
	private int count;
	private int proportion;

	public Food(String foodType, String petType, int count, int proportion) {
		super();
		this.foodType = foodType;
		this.petType = petType;
		this.count = count;
		this.proportion = proportion;
	}

	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
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

	public void addCount(int count) {
		this.count += count;
	}

}
