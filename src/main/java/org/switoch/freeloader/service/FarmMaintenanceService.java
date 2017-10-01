package org.switoch.freeloader.service;

import org.switoch.freeloader.command.Command;
import org.switoch.freeloader.domain.Farm;

public interface FarmMaintenanceService {

	public void process(Command task, Farm farm);

}
