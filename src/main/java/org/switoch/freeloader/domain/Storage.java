package org.switoch.freeloader.domain;

/**
 * Responsible for the keeping of {@link Food} instances.
 */
public class Storage {

	private Food[] foods;
	private BaseTank waterTank;
	private GarbageTank garbageTank;

	public Storage(Food... foods) {
		this.foods = foods;
		BaseTank waterTank = new WaterTank(30);
		GarbageTank garbageTank = new GarbageTank(10);
		this.setWaterTank(waterTank);
		this.setGarbageTank(garbageTank);
	}

	public Food[] getFoods() {
		return foods;
	}

	public static Storage getTestStorage() {
		Food fCat = new Food("wiskas", "cat", 5, 1);
		Food fDog = new Food("dried_chappi", "dog", 5, 2);
		Food fKitty = new Food("milk", "kitty", 5, 1);
		Food fPuppy = new Food("wet_chappi", "puppy", 5, 1);
		Food fFish = new Food("fish_food", "fish", 5, 0);
		Storage storage = new Storage(fCat, fDog, fKitty, fPuppy, fFish);
		return storage;
	}
	
	public BaseTank getWaterTank() {
		return waterTank;		
	}
	
	public GarbageTank getGarbageTank() {
		return garbageTank;		
	}

	public void setWaterTank(BaseTank waterTank) {
		this.waterTank = waterTank;
	}

	public void setGarbageTank(GarbageTank garbageTank) {
		this.garbageTank = garbageTank;
	}

	public static Storage loadFromDB() {
		// TODO implement later
		return null;
	}
	
	public static void daveToDB(Storage storage) {
	    // TODO implement later
	  }
}
