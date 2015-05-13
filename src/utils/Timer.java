package utils;

import java.util.concurrent.atomic.AtomicBoolean;

public class Timer {

	private long startTime = 0;
	private long MILLIS_TO_FIRE_EVENT = -1;
	private long ACTUAL_MILLIS_TO_FIRE_NEXT_EVENT = -1;
	private AtomicBoolean stopTimer = new AtomicBoolean(false);
	private AtomicBoolean isRunning = new AtomicBoolean(false);
	private TimerClass timerClass = null;
	private TimerInterface timerInterface = null;

	public Timer(long millisToFireEvent, TimerInterface timerInterface) {

		this.timerInterface = timerInterface;
		this.MILLIS_TO_FIRE_EVENT = millisToFireEvent;
		this.ACTUAL_MILLIS_TO_FIRE_NEXT_EVENT = millisToFireEvent;

		addShutDownHook();

	}

	public interface TimerInterface {
		public void fireEvent();
	}

	public void startTimer() {

		this.stopTimer.set(false);
		this.startTime = currentTimeMillis();
		this.timerClass = new TimerClass();
		this.isRunning.set(true);
		this.timerClass.start();

	}

	private class TimerClass extends java.lang.Thread {

		private long actualTimePassed = -1;

		@Override
		public void run() {

			while (true) {

				if (stopTimer.get())
					break;

				System.out.println(this);

				sleepTime(ACTUAL_MILLIS_TO_FIRE_NEXT_EVENT);

				this.actualTimePassed = currentTimeMillis() - startTime;

				ACTUAL_MILLIS_TO_FIRE_NEXT_EVENT = MILLIS_TO_FIRE_EVENT
						+ (MILLIS_TO_FIRE_EVENT - actualTimePassed);

				startTime += MILLIS_TO_FIRE_EVENT;

				if (stopTimer.get())
					break;

				fireEvent();

			}
		}
	}

	public void stopTimer() {
		this.isRunning.set(false);
		this.stopTimer.set(true);
	}

	private long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	private void sleepTime(long duration) {
		System.out.println(duration);
		Executor.sleep(duration);
	}

	private void fireEvent() {
		Executor.runLater(() -> this.timerInterface.fireEvent());
	}

	public boolean isRunning() {
		return this.isRunning.get();
	}

	private void addShutDownHook() {

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				stopTimer();
			}
		}));
	}

}
