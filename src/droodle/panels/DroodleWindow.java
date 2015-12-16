package droodle.panels;



import java.awt.BasicStroke;



import javax.swing.SwingUtilities;
import javax.swing.Timer;

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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;



public class DroodleWindow extends JPanel implements MouseListener, MouseMotionListener, Serializable {

 int drawStroke = 10;
 private Timer timer;
 //private Storage storage;
 private Boolean counting = false;
 private int counter = 10; // the duration
 private int delay = 1000; // every 1 second
 //private Storage storage;
 Storage storage = new Storage("sketches-6");
 List<Point> displayList = new ArrayList<Point>();

 //String paintname = "??";
 String pathname = "data.dat";
 
 
 

 
 public DroodleWindow(int strokeSize) {
   
  addMouseMotionListener(this);
  addMouseListener(this);
  
  setBackground(Color.GRAY);

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
                     DroodlePanel.pw.Save(DroodlePanel.pw.displayList);
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

  public void paint(Graphics g) {
   
   Graphics2D g2 = (Graphics2D) g;
   
   g2.setStroke(new BasicStroke(drawStroke));
   
      g.setColor(Color.GRAY);
      g.fillRect(0, 0, getSize().width, getSize().height);

      g.setColor(Color.black);
      int i = 0;
      
      
      while (i < this.displayList.size()) {
        Point p0 = (Point) (this.displayList.get(i++));
        //Point p1 = (Point) (displayList.get(i++));
        int x = (p0.x);
        int y = (p0.y);
        //int s = (p0.size);
        //int w = Math.abs(p0.x - p1.x);
        //int h = Math.abs(p0.y - p1.y);
        //if (slutt != null && start != null)
        g.drawLine(x, y, x, y);
      }
    }
  
  public void Save(List<Point> displayList) {
   System.out.println("Trying to save");
   try {
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();
       ObjectOutputStream os = new ObjectOutputStream(baos);
       os.writeObject(displayList);
       InputStream datastream = new ByteArrayInputStream(baos.toByteArray());
       storage.upload(datastream);
       os.flush();
       os.close();
       
        } catch (Exception ex) {
        	 // PrintStream ps = new PrintStream(baos);
        	    ex.printStackTrace();
          System.out.println("Trouble writing display list vector");
        }
  }
  
  
  
  //Public void push (vector<point> data) {
	 // BytearrayOutputStream baos = new byte arrayoutputstream();
	 // ObjectoutputStream serializer = new Objectoutputstream (out);
	 // Serializer.writeobject (data);
	 // Inputstream datastream = new bytearrayInputstream(baos.tobytearray());
	//  Storage.upload(datastream);
	  //}
  
 // public void Push(List<Point> displayList) {
	//  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 // ObjectOutputStream serializer = new ObjectOutputStream (out);
	 // serializer.writeObject (displayList);
	//  InputStream datastream = new ByteArrayInputStream(baos.toByteArray());
	 // Droodle.Storage.upload(displayList);
 // }
  
  public void GetDrawing() {
   System.out.println("GetDrawing");
   try {
          FileInputStream fis = new FileInputStream(pathname);
          ObjectInputStream ois = new ObjectInputStream(fis);
          displayList = (Vector) (ois.readObject());
          //Storage.upload(displayList);
          ois.close();
          fis.close();
          repaint();
        } catch (Exception ex) {
          System.out.println("Trouble reading display list vector");
        }
  }
  
  public void WipeDrawing() {
   System.out.println("wipe");
   displayList = new Vector();
      repaint();
  }
  
  
  public void mouseDragged(MouseEvent e) {
   start = slutt;
   slutt = new Point(e.getX(), e.getY());
   //this.drawStroke=drawStroke;
   DroodlePanel.pw.displayList.add(slutt);
   repaint();
  }
  
  public void mouseMoved(MouseEvent e) {
   slutt = null;
   //timer();
   
   DroodlePanel.pw.time();
  }
  
 

    public void mousePressed(MouseEvent e) {
      //Point p = new Point(e.getX(), e.getY());
      // displayList.add(p);
  
    
    }

    public void mouseReleased(MouseEvent e) {
     // Point p = new Point(e.getX(), e.getY());
      //displayList.add(p);
     // repaint();
    }

  @Override
  public void mouseClicked(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
  }
  
  //public void update(Graphics g) {
  // paint(g);
  //}

  Point start = null;
  Point slutt = null;

}