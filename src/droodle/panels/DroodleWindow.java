package droodle.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JPanel;

public class DroodleWindow extends JPanel implements MouseListener, MouseMotionListener, Serializable {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	private static final Color DA_BGCOLOR = Color.WHITE;
	private static final long serialVersionUID = 1L;

	private int drawStroke = 10;
	public Vector<Point> points = new Vector<Point>();

	private Color currentColor;
	public BufferedImage bImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public DroodleWindow(int strokeSize) {
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
		    DrawLines(g);

		    g.setColor(Color.black);
		    int i = 0;
		    while (i < points.size()) {
		      Point p0 = (Point) (points.get(i++));
		      //Point p1 = (Point) (displayList.get(i++));
		      int x = (p0.x);
		      int y = (p0.y);
		      //int w = Math.abs(p0.x - p1.x);
		      //int h = Math.abs(p0.y - p1.y);
		      //if (slutt != null && start != null)
		      g2.drawLine(x, y, x, y);
		    }
		  }
	 
	
	 
	 
	 
	 public void WipeDrawing() {
		 System.out.println("wipe");
		 points = new Vector();
	     repaint();
	 }
	 
	 
	 public void mouseDragged(MouseEvent e) {
		 points.add(e.getPoint());
			repaint();
		 
		 //start = slutt;
			//slutt = new Point(e.getX(), e.getY());
			//points.add(slutt);
			//repaint();
		}
	 
	 public void mouseMoved(MouseEvent e) {
			slutt = null;
		}

<<<<<<< HEAD
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRenderedImage(bImage, null);
		DrawLines(g);
		drawIntoBufferedImage();
		g2.setStroke(new BasicStroke(20));
		g.dispose();

	}
=======
		  public void mousePressed(MouseEvent e) {
		   
			  //points.clear();
				points.add(e.getPoint());
			  //Point p = new Point(e.getX(), e.getY());
		   // displayList.add(p);
		  }
>>>>>>> 578e1c7a6bc63b57b77ba8bfb800f66589f86096

		  public void mouseReleased(MouseEvent e) {
			  points.add(e.getPoint());
				//points.clear();
				//repaint();
			  
			  // Point p = new Point(e.getX(), e.getY());
		    //displayList.add(p);
		   // repaint();
		  }
		  
		  public void DrawLines(Graphics g) {
			  Graphics2D g2 = (Graphics2D) g;
				if (points != null && points.size() > 1) {
					//DroodlePanel.sf.time();

					//g.setColor(getCurrentColor());
					for (int i = 0; i < points.size() - 1; i++) {
						int x1 = points.get(i).x;
						int y1 = points.get(i).y;
						int x2 = points.get(i + 1).x;
						int y2 = points.get(i + 1).y;
						g.drawLine(x1, y1, x2, y2);
					}
				}
			}
		  
		  public void update(Graphics g) {
				paint(g);
			}

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		//public void update(Graphics g) {
		//	paint(g);
		//}

		Point start = null;
		Point slutt = null;

}
