package org.switoch.freeloader.command;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Pet;
import org.switoch.freeloader.service.FarmException;

public class CommandDecrementStorage implements Command{
	
	private final double satiety;

	public CommandDecrementStorage(double satiety) {
		super();
		this.satiety = satiety;
	}

	@Override
	public void apply(Farm farm) throws FarmException {
		for (Pet p : farm.getPets()) {
				p.addSatiety(p.getSatiety() + this.satiety);
		}
		
	}

}
