package droodle;

import droodle.storage.StorageFacade;
import storagetool.Storage;

public class Droodle {

	public static Storage storage;

	public static void main(String[] args) {

		storage = new Storage("sketches-6");
		String storageVersion = storage.getVersion();

		if ("Storage tool version 1.2" == storageVersion) {
			new SplashScreen();
		} else {
			throw new SecurityException("Use a newer version of Storagetool");
		}

	}

}
