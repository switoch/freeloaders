package org.switoch.freeloader.service;

public class BaseTank {

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