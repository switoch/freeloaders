package org.switoch.freeloader.command;

import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.service.FarmException;

public interface Command {

	void apply(Farm farm) throws FarmException;

}
