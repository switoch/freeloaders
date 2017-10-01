package org.switoch.freeloader;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.switoch.freeloader.command.Command;
import org.switoch.freeloader.command.CommandFeedPet;
import org.switoch.freeloader.dao.FarmDao;
import org.switoch.freeloader.dao.FarmDaoLocal;
import org.switoch.freeloader.domain.Farm;
import org.switoch.freeloader.domain.Pet;
import org.switoch.freeloader.service.FarmMaintenanceService;
import org.switoch.freeloader.service.FarmMaintenanceServiceDefault;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Bootstrap {

	private static Logger logger = Logger.getLogger(Bootstrap.class);

	private static FarmDao farmDao = new FarmDaoLocal();

	private static FarmMaintenanceService farmMaintenanceService = new FarmMaintenanceServiceDefault();

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {

		logger.info("Server started");

		logger.debug("Farm state loading...");
		Farm farm = farmDao.load();
		logger.debug("Farm state loaded: pets=" + farm.getPets().size());
		final Queue<Command> commandQueue = new ConcurrentLinkedQueue<>();
		ExecutorService executor = Executors.newFixedThreadPool(3);

		Runnable taskAdding = new Runnable() { 

			@Override
			public void run() {
				while (true) {
					for (int index = 0; index < farm.getPets().size();index++){
					logger.debug("Adding new feed command for pet " + index + " ...");
					commandQueue.add(new CommandFeedPet(index));
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						logger.warn("Adding new tasks in queue was stopped");
						return;
					}
				}
				
			}
		};
		executor.execute(taskAdding);


		Runnable watcherLifeCycle = new Runnable() {

			@Override
			public void run() {
				while (true) {
					logger.debug("watcher found " + commandQueue.size() + " tasks");
					while (true) {
						Command task = commandQueue.poll();
						if (task == null) {
							break;
						}
						logger.debug("wathcer begins his crazy work!!!!!");
						farmMaintenanceService.process(task, farm);
					}
					try {
						Thread.sleep(1000);
						logger.debug("watcher stops his work cause the queue is empty");
					} catch (InterruptedException e) {
						logger.warn("Taking new tasks in queue was stopped");
						return;
					}
				}
			}
		};

		executor.execute(watcherLifeCycle);


		// New scheduler for satiety decrementing
		Runnable satietyDecrementing = new Runnable() {

			@Override
			public void run() {
				while (true) {
					for (int index = 0; index < farm.getPets().size(); index++) {
						Pet p = farm.getPets().get(index);
						if (p.getSatiety() > 0) {
							logger.debug(String.format("current satiety level is %.1f for pet %d", p.getSatiety(), index));
							p.addSatiety(-0.1);
							if (p.getSatiety() < 0.1) {
								logger.debug("Kaputt");
							} else if (p.getSatiety() < 0.5) {
								logger.debug("I'm getting hungry and angry");
							} else if (p.getSatiety() < 0.7) {
								logger.debug("I'm getting hungry");
							}
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		executor.execute(satietyDecrementing);

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("Gracefully shutdown...");

				logger.debug("Shutdown processing executor");
				executor.shutdown();
				// watcherExecutor.shutdown();

				logger.debug("Farm state saving...");
				farmDao.save(farm);
				logger.debug("Farm state saved");
			}
		});
	}

}
