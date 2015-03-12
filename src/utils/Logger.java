package utils;

public class Logger {

	private static boolean logging = false;

	public static void startLogging() {
		logging = true;
	}

	public static void log(String log) {

		if (!logging)
			return;

		System.out.println(log);
	}

	public static void logNewLine(String log) {

		if (!logging)
			return;

		log(log);
		newLine();

	}

	public static void newLine() {

		if (!logging)
			return;

		System.out.println();
	}

}
