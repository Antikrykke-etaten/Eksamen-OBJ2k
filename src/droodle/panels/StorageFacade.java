package droodle.panels;




import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.microsoft.azure.storage.StorageException;

import droodle.Droodle;
import storagetool.Storage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseMotionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.URISyntaxException;

import java.util.Vector;

import javax.swing.JPanel;



public class StorageFacade extends JPanel implements Serializable {


 private Timer timer;

 private Boolean counting = false;
 private int counter = 5; 
 private int delay = 1000;

 Storage storage = new Storage("sketches-6");
 public Vector<Point> displayList = new Vector<Point>();
 
 private static final long serialVersionUID = 1234L;
 
 
 

 
 public StorageFacade() {
	 
 }
  
 
 
  public void time() {
   if (!counting){
    
    counting = true;
   ActionListener action = new ActionListener()
         {   
             @Override
             public void actionPerformed(ActionEvent event)
             {
                 if(counter == 0)
                 {
                     timer.stop();
                     counting = false;
                     counter = 5;
                     try {
						Save(displayList);
					} catch (IOException | URISyntaxException | StorageException e) {
						e.printStackTrace();
					}
                 }
                 else
                 {
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
	  DroodlePanel.dw.setCurrentColor(Color.GREEN);
   
  }
  
}