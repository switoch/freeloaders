package org.switoch.freeloader.service;

public class GarbageTank extends BaseTank {

	private double maxVolume;

	public double getMaxVolume() {
		return maxVolume;
	}

	public GarbageTank(double maxVolume) {
		super();
		this.maxVolume = maxVolume;
	}

}
