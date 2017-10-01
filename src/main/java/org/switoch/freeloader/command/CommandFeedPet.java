package org.switoch.freeloader.command;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Food;
import org.switoch.freeloader.domain.GarbageTank;
import org.switoch.freeloader.domain.Pet;
import org.switoch.freeloader.domain.Watcher;
import org.switoch.freeloader.domain.util.BaseTank;
import org.switoch.freeloader.service.FarmException;
import org.switoch.freeloader.service.FarmException.Type;

public class CommandFeedPet implements Command {

	private static final int FOOD_AMOUNT_PER_FEED = 1;

	private BaseTank waterTank;

	private GarbageTank garbageTank;

	private final int index;

	public CommandFeedPet(int index) {
		super();
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	@Override
	public void apply(Farm farm) throws FarmException {
		Pet pet = farm.getPets().get(this.index);
		Food food = null;
		for (Food f : farm.getStorage().getFoods()) {
			if (f.getPetType().equals(pet.getType())) {
				food = f;
			}
		}
		if (food == null) {
			throw new NullPointerException();
		}
		Watcher watcher = new Watcher();
		watcher.incrementFatigue(1);
		
		
		// TODO decrease satiety difference - X
		float currentSatiety = pet.getSatiety();
		float delta = 1 - currentSatiety;
		
		// TODO evaluate required amount of food if amount not enough\\\
		if (food.getCount() < FOOD_AMOUNT_PER_FEED /* replace*/) {
			throw new FarmException(Type.FOOD_NOT_ENOUGH, food.getFoodType(), null);
		}
		pet.addSatiety(delta);
		
		// TODO convert to float
		// TODO make it decreasing proportionally to X
		food.addCount(-FOOD_AMOUNT_PER_FEED);
		pet.setDirt(1);

		// add delay to simulate time
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void feed(Farm farm) {
	}

}
