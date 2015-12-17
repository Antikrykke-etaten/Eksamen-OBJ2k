package droodle;

import storagetool.Storage;

public class Droodle {

	public static void main(String[] args) {
		
		Storage storage = new Storage("sketches-6");
		String storageVersion = storage.getVersion();
		
		if ("Storage tool version 1.2" == storageVersion) {
			new SplashScreen();
		} else {
			throw new SecurityException("Use a newer version of Storagetool");
		}
		
	}

}
