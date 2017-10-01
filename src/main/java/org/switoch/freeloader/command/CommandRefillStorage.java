package org.switoch.freeloader.command;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Food;
import org.switoch.freeloader.domain.Storage;
import org.switoch.freeloader.service.FarmException;

public class CommandRefillStorage implements Command {

	private Object foodType;

	public CommandRefillStorage(Object foodType) {
		super();
		this.foodType = foodType;
	}

	@Override
	public void apply(Farm farm) throws FarmException {
		for (Food f : farm.getStorage().getFoods()) {
			if (f.getFoodType().equals(foodType)) {
				f.addCount(Storage.MAX_FOOD_AMMOUNT - f.getCount());
			}
		}

	}

}
