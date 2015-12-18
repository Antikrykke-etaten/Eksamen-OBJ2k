package droodle.storage;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import com.microsoft.azure.storage.StorageException;

import droodle.Configuration;
import droodle.Droodle;
import droodle.panels.DroodlePanel;
import storagetool.Storage;

public class SaveToAzureTask extends TimerTask {
	
	StorageFacade sf = new StorageFacade();
	
	@Override
	public void run() {
		try {
			sf.SaveTempJPG();
			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File("Temp.jpg"));

			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();

			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			Droodle.storage = new Storage(Configuration.teamName);
			Droodle.storage.setSketchname(DroodlePanel.sf.sketchName);
			Droodle.storage.upload(in);

			// BufferedImage bImageFromConvert = ImageIO.read(in);

			// Creates new image
			// ImageIO.write(bImageFromConvert, "jpg", new
			// File("new-Temp.jpg"));
			System.out.println("Saving to azure");

		} catch (IOException | URISyntaxException | StorageException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
