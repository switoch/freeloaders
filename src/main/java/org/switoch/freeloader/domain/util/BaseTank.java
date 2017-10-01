package org.switoch.freeloader.domain.util;

public abstract class BaseTank {

	private double volume;

	public BaseTank() {
		super();
	}

	public double getVolume() {
		return volume;
	}

	public void addVolume(double volume) {
		this.volume += volume;
	}

}