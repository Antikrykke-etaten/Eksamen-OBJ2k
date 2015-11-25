package droodle;

import java.util.List;

import droodle.file.Sketch;

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
