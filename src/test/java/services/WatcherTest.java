package services;

import org.junit.Assert;
import org.junit.Test;
import org.switoch.freeloader.service.Food;
import org.switoch.freeloader.service.Pet;
import org.switoch.freeloader.service.Watcher;
import org.switoch.freeloader.service.WaterTank;

public class WatcherTest {

	@Test
	public void testFeedProcess() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 1);
		WaterTank waterTank = new WaterTank(10);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food, waterTank);
		Assert.assertEquals("A pet is hungry", 1, pet.getSatiety());
		Assert.assertEquals("Amount of a food was not changed!", 4, food.getCount());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFeedProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 0, 1);
		WaterTank waterTank = new WaterTank(10);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food, waterTank);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWaterAProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 5);
		WaterTank waterTank = new WaterTank(3);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food, waterTank);
	}
	
	@Test()
	public void testWaterBProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 1, 5);
		WaterTank waterTank = new WaterTank(5);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food, waterTank);
		Assert.assertEquals("Amount of water", 0, waterTank.getVolume());
		Assert.assertEquals("Amount of food", 0, food.getCount());
	}
}
