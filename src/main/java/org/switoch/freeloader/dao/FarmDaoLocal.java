package org.switoch.freeloader.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Pet;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FarmDaoLocal implements FarmDao {

	private final String FOLDER = "C:\\document\\work\\workspace\\ws1\\test5_freeloaders\\";

	@Override
	public void save(Farm farm) {
	}

	@Override
	public Farm load() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Farm loadFromJson() throws JsonParseException, JsonMappingException, IOException {
		Farm farm = null;
		try {
			ObjectMapper om = new ObjectMapper();
			Pet[] pets = om.readValue(new FileInputStream("farm.json"), Pet[].class);
			farm = new Farm(pets);
		} catch (FileNotFoundException e) {
			farm = Farm.getTestFarm();
		}
		return farm;
	}

	public static void saveToJson(Object object)
			throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		ObjectMapper om = new ObjectMapper();
		//Farm farm = null;
			om.writeValue(new FileOutputStream("farm.json"), object);
	}

}
