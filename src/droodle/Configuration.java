package droodle;

public class Configuration {
	
	public String teamName = "sketches-6";
	public String assetsFolder = System.getProperty("user.dir") + "/src/droodle/assets/";
	public String fileExtension = ".droodle";
	public String fileTreeXML = assetsFolder + "fileTree.xml";
	public String[] loadingBarStrings = new String[] {
			"Loading colors...", 
			"Ooo, baby I love you way...",
			"Every day...",
			"Yeah, yeah...",
			"Setting constants..."
	};

}