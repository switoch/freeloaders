package org.switoch.freeloader;

import java.util.HashMap;
import java.util.Map;

import org.switoch.freeloader.service.Farm;
import org.switoch.freeloader.service.Food;
import org.switoch.freeloader.service.Pet;
import org.switoch.freeloader.service.Storage;
import org.switoch.freeloader.service.Watcher;

public class Bootstrap {

	public static void main(String[] args) {

		// Definition

		Farm farm = Farm.getTestFarm();
		Storage storage = Storage.getTestStorage();

		// Feeding

		Watcher watcher = new Watcher();

		watcher.setWaterTank(storage.getWaterTank());
		watcher.setGarbageTank(storage.getGarbageTank());
		
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
			watcher.clean(pet, storage.getGarbageTank());
			System.out.println(pet.toString());
		}
	}

}
