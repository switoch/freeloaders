package org.switoch.freeloader.service;

/**
 * Responsible for pets feeding
 */
public class Watcher {

	private static final int FOOD_AMOUNT_PER_FEED = 1;

	/**
	 * Allows to feed a pet with specified food
	 * 
	 * @param pet
	 *            - the target instance of {@link Pet};
	 * @param food
	 *            - the corresponding instance of {@link Food} required for
	 *            feeding of specified {@link Pet} instance;
	 */
	public void feed(Pet pet, Food food, WaterTank water) {
		if (food.getCount() < FOOD_AMOUNT_PER_FEED) {
			throw new IllegalArgumentException("Food amount is not enough");
		}
		if (water.getVolume() < FOOD_AMOUNT_PER_FEED*food.getProportion()) {
			throw new IllegalArgumentException("Water amount is not enough");
		}
		food.setCount(food.getCount() - FOOD_AMOUNT_PER_FEED);
		pet.setSatiety(pet.getSatiety() + FOOD_AMOUNT_PER_FEED);
		water.setVolume(water.getVolume() - FOOD_AMOUNT_PER_FEED*food.getProportion());
	}

}
