package services;

import org.junit.Assert;
import org.junit.Test;
import org.switoch.freeloader.service.BaseTank;
import org.switoch.freeloader.service.Food;
import org.switoch.freeloader.service.GarbageTank;
import org.switoch.freeloader.service.Pet;
import org.switoch.freeloader.service.Watcher;
import org.switoch.freeloader.service.WaterTank;

public class WatcherTest {

	@Test
	public void testFeedProcess() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 1);
		BaseTank waterTank = new WaterTank(10);
		GarbageTank garbageTank = new GarbageTank(1.0);
		Watcher watcher = new Watcher();
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
		Assert.assertEquals("A pet is hungry", 1, pet.getSatiety());
		Assert.assertEquals("Amount of a food was not changed!", 4, food.getCount());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFeedProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 0, 1);
		BaseTank waterTank = new WaterTank(10);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(1.0);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWaterAProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 5);
		BaseTank waterTank = new WaterTank(3);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(1.0);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
	}

	@Test()
	public void testWaterBProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 1, 5);
		BaseTank waterTank = new WaterTank(5);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(1.0);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
		Assert.assertEquals("Amount of water", 0, waterTank.getVolume(), 0);
		Assert.assertEquals("Amount of food", 0, food.getCount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGarbageIsFull() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 1);
		BaseTank waterTank = new WaterTank(3);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(0.0);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
		watcher.clean(pet, garbageTank);
	}

	@Test()
	public void testGarbage() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 1);
		BaseTank waterTank = new WaterTank(3);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(0.5);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
		watcher.clean(pet, garbageTank);
		Assert.assertEquals("Amount of garbage", 0.5, garbageTank.getVolume(), 0);
	}
	
	@Test()
	public void testCleanGarbage() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5, 1);
		BaseTank waterTank = new WaterTank(3);
		Watcher watcher = new Watcher();
		GarbageTank garbageTank = new GarbageTank(0.5);
		watcher.setWaterTank(waterTank);
		watcher.setGarbageTank(garbageTank);
		watcher.feed(pet, food);
		watcher.clean(pet, garbageTank);
		Assert.assertEquals("Amount of dirt", 0, pet.getDirt(), 0);
	}
}
