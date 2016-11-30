package services;

import org.junit.Assert;
import org.junit.Test;

public class WatcherTest {

	@Test
	public void testFeedProcess() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), 5);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food);
		Assert.assertEquals("A pet is hungry", 1, pet.getSatiety());
		Assert.assertEquals("Amount of a food was not changed!", 4, food.getCount());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFeedProcessException() {
		Pet pet = new Pet("cat");
		Food food = new Food("wiskas", pet.getType(), -1);
		Watcher watcher = new Watcher();
		watcher.feed(pet, food);
	}
}
