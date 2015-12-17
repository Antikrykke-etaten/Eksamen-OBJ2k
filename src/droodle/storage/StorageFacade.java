package droodle.storage;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.microsoft.azure.storage.StorageException;

import droodle.Configuration;
import storagetool.Storage;

public class StorageFacade extends JPanel implements Serializable {

	private Timer timer;
	private Configuration Config;

	private Boolean counting = false;
	private int counter = 5;
	private int delay = 1000;

	Storage storage = new Storage("sketches-6");
	public Vector<Point> displayList = new Vector<Point>();

	private static final long serialVersionUID = 1234L;

	public void time() {
		if (!counting) {

			counting = true;
			ActionListener action = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					if (counter == 0) {
						timer.stop();
						counting = false;
						counter = 5;
						try {
							Save(displayList);
						} catch (IOException | URISyntaxException | StorageException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println(counter);
						counter--;
					}
				}
			};

			timer = new Timer(delay, action);
			timer.setInitialDelay(0);
			timer.start();
		}
	}

	public void Save(Vector<Point> displayList) throws IOException, URISyntaxException, StorageException {
		System.out.println("Trying to save");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream serialiser = new ObjectOutputStream(baos);

		serialiser.writeObject(displayList);
		serialiser.close();

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		storage.upload(bais);
	}

	public void Load() {
		System.out.println("Trying to load");
	}

	public void WipeDrawing() {
		System.out.println("Trying to wipe drawing");

	}
	
	public void Save2() throws URISyntaxException, StorageException{
		try {
		 File imgPath = new File(Config.assetsFolder + "Temp.jpg");
		 BufferedImage bufferedImage = ImageIO.read(imgPath);
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		 
		 ByteArrayOutputStream os = new ByteArrayOutputStream();
		 ImageIO.write(bufferedImage, "jpg", os);
		 InputStream is = new ByteArrayInputStream(os.toByteArray());
		 
		 storage.upload(is);
		
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}