package org.switoch.freeloader.service.util;

import java.util.ArrayList;
import java.util.List;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Food;
import org.switoch.freeloader.domain.Pet;
import org.switoch.freeloader.domain.Storage;

public class FarmFactory {

	public static Farm getTestFarm() {
//		Pet pCat1 = new Pet("cat");
//		//Pet pCat2 = new Pet("cat");
//		Pet pDog = new Pet("dog");
//		Pet pKitty = new Pet("kitty");
//		Pet pPuppy = new Pet("puppy");
//		Pet pFish = new Pet("fish");
//		return new Farm(pCat1, pDog, pKitty, pPuppy, pFish);
		List<Pet> pets = new ArrayList<Pet>();
		List<Food> foods = new ArrayList<Food>();
		pets.add(0, PetFactory.createRandomCat("cat"));
		pets.get(0).setName("Dimitry");
		foods.add(0, new Food("kittycat", pets.get(0).getType(), Storage.MAX_FOOD_AMMOUNT, 1));
		pets.add(1, PetFactory.createRandomDog("dog"));
		foods.add(1, new Food("wetfood", pets.get(1).getType(), Storage.MAX_FOOD_AMMOUNT, 1));
		Storage storage = new Storage();
		storage.setFoods(foods);
		Farm farm = new Farm();
		farm.setPets(pets);
		farm.setStorage(storage);
		return farm;
	}
}
