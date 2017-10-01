package org.switoch.freeloader.domain;

import java.util.List;

/**
 * Responsible for the keeping of {@link Pet} instances.
 */
public class Farm {

	private Storage storage;
	
	private Watcher watcher;
	
	private List<Pet> pets;

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Watcher getWatcher() {
		return watcher;
	}

	public void setWatcher(Watcher watcher) {
		this.watcher = watcher;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
}
