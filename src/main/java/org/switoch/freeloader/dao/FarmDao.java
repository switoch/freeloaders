package org.switoch.freeloader.dao;

import org.switoch.freeloader.domain.Farm;

public interface FarmDao {

	public void save(Farm farm);

	public Farm load();

}
