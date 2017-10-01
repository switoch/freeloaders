package org.switoch.freeloader.domain;

import org.switoch.freeloader.domain.util.BaseTank;

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
