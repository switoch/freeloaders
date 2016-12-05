package org.switoch.freeloader.service;

/**
 *Responsible for the keeping of {@link Pet} instances.
 */
public class Farm {

	private Pet[] pets;

	public Farm(Pet... pets) {
		super();
		this.pets = pets;
	}

	public Pet[] getPets() {
		return pets;
	}

	public static Farm getTestFarm() {
		Pet pCat1 = new Pet("cat");
		Pet pCat2 = new Pet("cat");
		Pet pDog = new Pet("dog");
		Pet pKitty = new Pet("kitty");
		Pet pPuppy = new Pet("puppy");
		Pet pFish = new Pet("fish");
		return new Farm(pCat1, pCat2, pDog, pKitty, pPuppy, pFish);
	}

	public static Farm loadFromDB() {
		// TODO implement later
		return null;
	}

}
