package droodle.storage;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.commons.io.IOUtils;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobInputStream;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import droodle.Configuration;
import droodle.Droodle;
import droodle.panels.DroodlePanel;
import storagetool.Storage;
import storagetool.StorageAccount;

public class StorageFacade extends JPanel implements Serializable {

	private Timer timer;
	private int delay = 5000;
	public String sketchName;

	private static final long serialVersionUID = 1L;

	// public void time() {
	// ActionListener action = new ActionListener() {
	// @Override
	// public void actionPerformed(ActionEvent event) {
	// timer.stop();
	// try {
	// SaveToAzure();
	// } catch (URISyntaxException | StorageException e) {
	// TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// };

	// timer = new Timer(delay, action);
	// timer.setInitialDelay(0);
	// timer.start();
	// }

	public void Save(Vector<Point> points) {
		System.out.println("Save");
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream serialiser = new ObjectOutputStream(baos);

			serialiser.writeObject(DroodlePanel.dw.points);
			serialiser.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

			Droodle.storage.setSketchname(sketchName);
			Droodle.storage.upload(bais);

		} catch (Exception ex) {
			System.out.println("Trouble writing display list vector");
		}
	}

	public void LoadPoints() throws IOException, ClassNotFoundException {
		try {
			Droodle.storage.setSketchname(sketchName);
			BlobInputStream datastream = Droodle.storage.download();

			ObjectInputStream ois = new ObjectInputStream(datastream);
			Vector<Point> test = (Vector<Point>) ois.readObject();

			for (Point integer : test) {
				DroodlePanel.dw.points.add(integer);

				System.out.println("Fant " + integer);
			}
			System.out.println("FERDIG");

			// DroodlePanel.dw.bImage = ImageIO.read(new
			// File("Loaded-Temp.jpg"));

		} catch (URISyntaxException | StorageException e) {
			e.printStackTrace();
		}
	}

	public void deleteFile(String sketchName) {
		CloudStorageAccount sa = StorageAccount.getInstance().getStorageAccount();
		CloudBlobClient cbc = sa.createCloudBlobClient();
		try {
			CloudBlobContainer c = cbc.getContainerReference("sketches-" + Configuration.teamName);
			CloudBlockBlob blob = c.getBlockBlobReference(sketchName);
			blob.deleteIfExists();
		} catch (URISyntaxException | StorageException e) {
			e.printStackTrace();
		}
	}

	public void deleteAllFiles() {
		ArrayList<String> allFiles = getSketchList();
		System.out.println("Sletter " + allFiles.size() + " filer.");
		for (String fileName : allFiles) {
			System.out.println("Sletter filen: " + fileName);
			deleteFile(fileName);
		}
	}

	public void SaveTempJPG() {
		try {
			File outputfile = new File("Temp.jpg");
			ImageIO.write(DroodlePanel.dw.bImage, "jpg", outputfile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void SaveToAzure() throws URISyntaxException, StorageException {
		try {
			SaveTempJPG();
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
			Droodle.storage = new Storage("sketches-6");
			Droodle.storage.setSketchname(sketchName);
			Droodle.storage.upload(in);

			// BufferedImage bImageFromConvert = ImageIO.read(in);

			// Creates new image
			// ImageIO.write(bImageFromConvert, "jpg", new
			// File("new-Temp.jpg"));
			System.out.println("Saving to azure");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void newSketch() {
		DroodlePanel.dw.WipeDrawing();
	}

	public ArrayList<String> getSketchList() {
		return Droodle.storage.getFilenames();
	}

	public void LoadSketch() throws URISyntaxException, StorageException, IOException {
		OutputStream outStream = null;
		ByteArrayOutputStream byteOutStream = null;
		try {
			Droodle.storage.setSketchname(DroodlePanel.sf.sketchName);
			BlobInputStream datastream = Droodle.storage.download();

			byte[] bytes = IOUtils.toByteArray(datastream);

			outStream = new FileOutputStream("Loaded-Temp.jpg");
			byteOutStream = new ByteArrayOutputStream();
			// writing bytes in to byte output stream
			byteOutStream.write(bytes); // data
			byteOutStream.writeTo(outStream);
			System.out.println("Loading selected Sketch");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outStream.close();
		}

		DroodlePanel.dw.bImage = ImageIO.read(new File("Loaded-Temp.jpg"));
	}

}