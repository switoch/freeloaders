package org.switoch.freeloader.service;

import org.apache.log4j.Logger;
import org.switoch.freeloader.command.Command;
import org.switoch.freeloader.command.CommandFeedPet;
import org.switoch.freeloader.command.CommandRefillStorage;
import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.service.FarmException.Type;

public class FarmMaintenanceServiceDefault implements FarmMaintenanceService {

	private static Logger logger = Logger.getLogger(FarmMaintenanceServiceDefault.class);

	@Override
	public void process(Command task, Farm farm) {

		// prepare commands
		// List<CommandFeedPet> commands = new ArrayList<>();
		// for (int i = 0; i < farm.getPets().size(); i++) {
		// CommandFeedPet command = new CommandFeedPet(i);
		// commands.add(command);
		// }
		//
		// // apply commands
		// for (Command c : commands) {
		// c.apply(farm);
		// }
		
		CommandFeedPet command = (CommandFeedPet) task;
 		
			logger.info("I am going to feed the pet " + farm.getPets().get(command.getIndex()).getName() + "...");
			try {
				task.apply(farm);
			} catch (FarmException e) {
				if (e.getCode() == Type.FOOD_NOT_ENOUGH) {
					Object foodType = e.getValue1();
					logger.info("I cannot feed pet because " + foodType + " is not enough");
					// execute new command storage refill
					try {
						logger.info("I should refill food storage...");
						new CommandRefillStorage(foodType).apply(farm);
						logger.info("Food storage was gratefully refilled");
					} catch (FarmException e1) {
						// Never executed
					}
				}
		}
	}

}
