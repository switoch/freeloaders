package org.switoch.freeloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.switoch.freeloader.domain.Pet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Pet pet = new Pet("cat");
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new FileOutputStream("pet.json"), pet);
		Pet pet11 = om.readValue(new FileInputStream("pet.json"), Pet.class);
		System.out.println(pet11.toString());

	}

}
