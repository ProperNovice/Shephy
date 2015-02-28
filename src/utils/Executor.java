package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

	private static ExecutorService executorService = Executors
			.newCachedThreadPool();

	private Executor() {

	}

	public static void runLater(Runnable runnable) {
		executorService.submit(runnable);
	}

	public static void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
