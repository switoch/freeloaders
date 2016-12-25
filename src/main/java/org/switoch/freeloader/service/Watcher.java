package org.switoch.freeloader.service;

/**
 * Responsible for pets feeding
 */
public class Watcher {

	private static final int FOOD_AMOUNT_PER_FEED = 1;
	private BaseTank waterTank;
	private GarbageTank garbageTank;

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
		if (food.getCount() < FOOD_AMOUNT_PER_FEED) {
			throw new IllegalArgumentException("Food amount is not enough");
		}
		if ((waterTank.getVolume() - FOOD_AMOUNT_PER_FEED * food.getProportion()) < 0) {
			throw new IllegalArgumentException("Water amount is not enough");
		}
		pet.setSatiety(1);
		food.addCount(- FOOD_AMOUNT_PER_FEED);
		waterTank.addVolume(- FOOD_AMOUNT_PER_FEED * food.getProportion());
		pet.setDirt(1);
	}

	/**
	 * Allows to clean a pet's cage after successful feeding
	 * 
	 * @param pet
	 *            - the target instance of {@link Pet};
	 * @param garbage
	 *            - the corresponding instance of {@link GarbageTank} required
	 *            for getting garbage from specified {@link Pet} instance;
	 */
	public void clean(Pet pet, GarbageTank garbage) {
		if ((garbageTank.getVolume() + FOOD_AMOUNT_PER_FEED * 0.5) > garbageTank.getMaxVolume()) {
			throw new IllegalArgumentException("Garbage tank is full for " + pet.getType());
		}
		if (pet.getDirt() == 1) {
			garbage.addVolume(FOOD_AMOUNT_PER_FEED * 0.5);
			pet.setDirt(0);
		}
	}

	public void setWaterTank(BaseTank waterTank) {
		this.waterTank = waterTank;

	}

	public void setGarbageTank(GarbageTank garbageTank) {
		this.garbageTank = garbageTank;

	}

}
