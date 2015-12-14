package droodle.panels;



import java.awt.BasicStroke;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintWindowPanel extends JPanel implements MouseListener, MouseMotionListener {

	private int drawStroke = 10;
	List<Point> displayList = new ArrayList<Point>();

	//String paintname = "??";
	String pathname = "data.dat";
	
	

	
	public PaintWindowPanel(int strokeSize) {
		addMouseMotionListener(this);
		addMouseListener(this);
		this.drawStroke=strokeSize;
		setBackground(Color.GRAY);
	}
	
	 public void paint(Graphics g) {
		 
		 Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(drawStroke));
		    g.setColor(Color.GRAY);
		    g.fillRect(0, 0, getSize().width, getSize().height);

		    g.setColor(Color.black);
		    int i = 0;
		    while (i < displayList.size()) {
		      Point p0 = (Point) (displayList.get(i++));
		      //Point p1 = (Point) (displayList.get(i++));
		      int x = (p0.x);
		      int y = (p0.y);
		      //int w = Math.abs(p0.x - p1.x);
		      //int h = Math.abs(p0.y - p1.y);
		      //if (slutt != null && start != null)
		      g2.drawLine(x, y, x, y);
		    }
		  }
	 
	 public void Save() {
		 System.out.println("Save");
		 try {
		        FileOutputStream fos = new FileOutputStream(pathname);
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		        oos.writeObject(displayList);
		        oos.flush();
		        oos.close();
		        fos.close();
		      } catch (Exception ex) {
		        System.out.println("Trouble writing display list vector");
		      }
	 }
	 
	 public void GetDrawing() {
		 System.out.println("GetDrawing");
		 try {
		        FileInputStream fis = new FileInputStream(pathname);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        displayList = (Vector) (ois.readObject());
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
			displayList.add(slutt);
			repaint();
		}
	 
	 public void mouseMoved(MouseEvent e) {
			slutt = null;
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
		//	paint(g);
		//}

		Point start = null;
		Point slutt = null;

}


