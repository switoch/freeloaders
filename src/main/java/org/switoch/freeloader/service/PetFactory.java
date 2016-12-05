package org.switoch.freeloader.service;

public class PetFactory {

	public static Pet createRandomCat(String name) {
		Pet pet = new Pet(name);
		pet.setName(name);
		return pet;
	}

}
