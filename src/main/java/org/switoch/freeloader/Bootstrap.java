package org.switoch.freeloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.switoch.freeloader.dao.FarmDaoLocal;
import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Food;
import org.switoch.freeloader.domain.Pet;
import org.switoch.freeloader.domain.Storage;
import org.switoch.freeloader.domain.Watcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Bootstrap {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		// Definition

		// read farm from farm.json, if null Farm.getTestFarm();
		
		//Farm farm = null;
		Storage storage = null;

		Farm farm = FarmDaoLocal.loadFromJson();
		// try {
		// ObjectMapper om = new ObjectMapper();
		// Pet[] pets = om.readValue(new FileInputStream("farm.json"),
		// Pet[].class);
		// farm = new Farm(pets);
		// } catch (FileNotFoundException e) {
		// farm = Farm.getTestFarm();
		// }
		//
		 try {
		 ObjectMapper om = new ObjectMapper();
		 Food[] food = om.readValue(new FileInputStream("storage.json"),
		 Food[].class);
		 storage = new Storage(food);
		 } catch (FileNotFoundException e) {
		 storage = Storage.getTestStorage();
		 }

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

		FarmDaoLocal.saveToJson(farm.getPets());
		 ObjectMapper om = new ObjectMapper();
		 om.writeValue(new FileOutputStream("storage.json"), storage.getFoods());
	}

}
