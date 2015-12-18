package droodle.storage;

import java.awt.Image;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobInputStream;

import droodle.Configuration;
import droodle.Droodle;
import droodle.panels.DroodlePanel;
import storagetool.Storage;

public class StorageFacade extends JPanel implements Serializable {

	private Timer timer;

	private Boolean counting = false;
	private int counter = 5;
	private int delay = 1000;
	
	public String sketchName;

	public Vector<Point> displayList = new Vector<Point>();

	private static final long serialVersionUID = 1L;

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
		Droodle.storage.upload(bais);
	}

	
	public void SaveToAssets() {
		System.out.println("Saving to assets");
		try {
		File outputfile = new File("Temp.jpg");
		ImageIO.write(DroodlePanel.dw.bImage, "jpg", outputfile);
		System.out.println("funka?");
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void WipeDrawing() {
		System.out.println("Trying to wipe drawing");

	}
	
	public void Save2() throws URISyntaxException, StorageException{
		try {
			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File(
					"Temp.jpg"));

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
			
			//BufferedImage bImageFromConvert = ImageIO.read(in);

			//Creates new image
			//ImageIO.write(bImageFromConvert, "jpg", new File("new-Temp.jpg"));
			System.out.println("Writing to server");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//Droodle.storage.setSketchname("sketchName");
	 //BlobInputStream datastream = Droodle.storage.download();
	 
	 //byte[] bytes = IOUtils.toByteArray(datastream);
	public void LoadSketch() throws URISyntaxException, StorageException, IOException{
		 OutputStream outStream = null;  
		 ByteArrayOutputStream byteOutStream = null;  
		 try {
			Droodle.storage.setSketchname("Smiley");
			 BlobInputStream datastream = Droodle.storage.download();
			 
			 byte[] bytes = IOUtils.toByteArray(datastream);
			 
			   outStream = new FileOutputStream("Loaded-Temp.jpg");  
			   byteOutStream = new ByteArrayOutputStream();  
			   // writing bytes in to byte output stream  
			   byteOutStream.write(bytes); //data  
			   byteOutStream.writeTo(outStream); 
			   System.out.println("Loading Sketch");
			 } catch (IOException e) {  
			   e.printStackTrace();  
			 } finally {  
			   outStream.close();  
			 } 
		
	}
	

	//storage.upload(bStream);
	

}