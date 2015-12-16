package droodle.panels;



import java.awt.BasicStroke;



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



 //String paintname = "??";
 String pathname = "data.dat";
 
 
 
 

 
 public DroodleWindow(int strokeSize) {
   
  addMouseMotionListener(this);
  addMouseListener(this);
  
  setBackground(Color.GRAY);
 

 }
 
 

  public void paint(Graphics g) {
   
   Graphics2D g2 = (Graphics2D) g;
   
   g2.setStroke(new BasicStroke(drawStroke));
   
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, getSize().width, getSize().height);

      g.setColor(Color.black);
      int i = 0;
      
      
      while (i < DroodlePanel.sf.displayList.size()) {
        Point p0 = (Point) (DroodlePanel.sf.displayList.get(i++));
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
  

  
  
  

 
  
  
  public void mouseDragged(MouseEvent e) {
   start = slutt;
   slutt = new Point(e.getX(), e.getY());
   //this.drawStroke=drawStroke;
   //DroodlePanel.sf.displayList.add(Point);
   DroodlePanel.sf.displayList.add(e.getPoint());
   repaint();
  }
  
  public void mouseMoved(MouseEvent e) {
   slutt = null;
   //timer();
   

   DroodlePanel.sf.time();

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

  Point start = null;
  Point slutt = null;

}