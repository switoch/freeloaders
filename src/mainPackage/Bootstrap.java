package mainPackage;

import java.util.HashMap;
import java.util.Map;

import services.Farm;
import services.Food;
import services.Pet;
import services.Storage;
import services.Watcher;

public class Bootstrap {

	public static void main(String[] args) {

		// Definition

		Farm farm = Farm.getTestFarm();
		Storage storage = Storage.getTestStorage();

		// Feeding

		Watcher watcher = new Watcher();

		// Indexing between a pet type and a food for it
		Map<String, Food> foodByPerTypeMap = new HashMap<>();
		for (Food f : storage.getFoods()) {
			foodByPerTypeMap.put(f.getPetType(), f);
		}

		for (Pet pet : farm.getPets()) {
			System.out.println(pet.toString());
			Food food = foodByPerTypeMap.get(pet.getType());
			if (food != null) {
				watcher.feed(pet, food);
			} else {
				System.out.println("Food for " + pet.getType() + " is missed!");
			}
			System.out.println(pet.toString());
		}
	}

}
