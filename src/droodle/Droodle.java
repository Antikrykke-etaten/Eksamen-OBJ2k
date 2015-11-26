package droodle;

<<<<<<< HEAD
import storagetool.Storage;
=======
import java.util.List;

import droodle.file.Sketch;
>>>>>>> 6a1a25c58a9ce588269922cd270dfb242ca511eb

public class Droodle {

	public static void main(String[] args) {
		List<Sketch> sketchnames;
		String names = "";
		try {
			sketchnames = new FileTreeParser().getSketchNames();
			for (Sketch sketch : sketchnames) {
				names += sketch.getSketchName() + " ";
			}
			System.out.println(names);
		} catch (Exception e) {
			e.printStackTrace();
		}

		new SplashScreen();
	}

}
