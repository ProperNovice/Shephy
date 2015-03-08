package utils;

import javafx.application.Platform;

public class PlatformFX {

	public static void runLater(Runnable runnable) {

		if (Platform.isFxApplicationThread())
			runnable.run();
		else
			Platform.runLater(runnable);

	}

	public static boolean isFxApplicationThread() {
		return Platform.isFxApplicationThread();
	}

}
