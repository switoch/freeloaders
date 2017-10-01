package org.switoch.freeloader.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.service.util.FarmFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FarmDaoLocal implements FarmDao {

	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void save(Farm farm) {
		try {
			saveToJson(farm);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public Farm load() {
		try {
			return loadFromJson();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	public Farm loadFromJson() throws JsonParseException, JsonMappingException, IOException {
		Farm farm = null;
		try {
			farm = om.readValue(new FileInputStream("farm.json"), Farm.class);
		} catch (FileNotFoundException e) {
			farm = FarmFactory.getTestFarm();
		}
		return farm;
	}

	public void saveToJson(Object object)
			throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		om.writeValue(new FileOutputStream("farm.json"), object);
	}

}
