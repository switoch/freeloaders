package org.switoch.freeloader.service;

/**
 * Responsible for pets feeding
 */
public class Watcher {

	/**
	 * Allows to feed a pet with specified food
	 * 
	 * @param pet
	 *            - the target instance of {@link Pet};
	 * @param food
	 *            - the corresponding instance of {@link Food} required for
	 *            feeding of specified {@link Pet} instance;
	 */
	public void feed(Pet pet, Food food) {
	    if (food.getCount() <= 1) {
	        throw new IllegalArgumentException("Food amount is not enough");
	      }
	        food.setCount(food.getCount() - 1);
	        pet.setSatiety(pet.getSatiety() + 1);
	}

}
