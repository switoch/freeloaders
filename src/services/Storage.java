package services;

/**
 *Responsible for the keeping of {@link Food} instances.
 */
public class Storage {
	
	private Food[] foods;
	
	public Storage(Food... foods){
		this.foods = foods;
	}
	
	
	public Food[] getFoods() {
		return foods;
	}
	
	public static Storage getTestStorage() {
		Food fCat = new Food("wiskas", "cat", 5);
		Food fDog = new Food("dried_chappi", "dog", 5);
		Food fKitty = new Food("milk", "kitty", 5);
		Food fPuppy = new Food("wet_chappi", "puppy", 5);
		Food fFish = new Food("fish_food", "fish", 5);
		return new Storage(fCat, fDog, fKitty, fPuppy, fFish);
	}

	public static Storage loadFromDB() {
		// TODO implement later
		return null;
	}
}
