package org.switoch.freeloader.service;

import org.switoch.freeloader.domain.Pet;

public class PetFactory {

	public static Pet createRandomCat(String name) {
		Pet pet = new Pet(name);
		pet.setName(name);
		return pet;
	}

}
