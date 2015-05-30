package utils;

public class Lock {

	private static Semaphore semaphore = new Semaphore();

	private static class Semaphore {

		private java.util.concurrent.Semaphore semaphore = null;

		public Semaphore() {
			this.semaphore = new java.util.concurrent.Semaphore(0);
		}

		public void releasePermit() {
			this.semaphore.release();
		}

		public void acquirePermit() {
			try {
				this.semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public int availablePermits() {
			return this.semaphore.availablePermits();
		}

	}

	public static void lock() {

		Logger.log("lock");
		semaphore.acquirePermit();
		Logger.log("unlock");
		Logger.logNewLine("available permits : " + semaphore.availablePermits());

	}

	public static void unlock() {
		semaphore.releasePermit();
	}

}
