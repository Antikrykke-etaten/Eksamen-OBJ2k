package droodle.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import droodle.CardController;

public class DroodleWindow extends JPanel implements Serializable {

	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	private static final Color DA_BGCOLOR = Color.WHITE;
	private static final long serialVersionUID = 1L;

	ArrayList<Point> points = new ArrayList<Point>();
	Vector<Point> points1 = new Vector<Point>();

	private Color currentColor;
	public BufferedImage bImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	

	public DroodleWindow() {
		
		
		Rectangle r = CardController.frame.getBounds();
		//h = r.height;
		//w = r.width;
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		

		// Basic Settings for bImage
		Graphics g2d = bImage.getGraphics();
		Graphics2D g2 = (Graphics2D) g2d;
		g2.drawRenderedImage(bImage, null);
		g2.setColor(DA_BGCOLOR);
		g2.fillRect(0, 0, r.width, r.height);
		g2.dispose();

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				points.clear();
				points.add(e.getPoint());
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				points.add(e.getPoint());
				repaint();
			}

		});

		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				points.add(e.getPoint());
				points.clear();
				repaint();
			}
		});
	}
	
	public void changeBufferedImage() throws IOException{
		
		DroodlePanel.dw.bImage = ImageIO.read(new File("Loaded-Temp.jpg"));
	}

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

	public void drawIntoBufferedImage() {
		Graphics g = bImage.getGraphics();
		DrawLines(g);
		g.dispose();
	}

	public void DrawLines(Graphics g) {
		if (points != null && points.size() > 1) {
			DroodlePanel.sf.time();

			g.setColor(getCurrentColor());
			for (int i = 0; i < points.size() - 1; i++) {
				int x1 = points.get(i).x;
				int y1 = points.get(i).y;
				int x2 = points.get(i + 1).x;
				int y2 = points.get(i + 1).y;
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}

	// clear drawings method
	public void clearDrawings() {
		if (points != null) {
			points.clear();
			Graphics g = bImage.getGraphics();
			g.setColor(DA_BGCOLOR);
			g.fillRect(0, 0, WIDTH, WIDTH);
			g.dispose();
			repaint();
		}

	}

	public void setCurrentColor(Color currentColor) {
		if (currentColor == null) {
			currentColor = Color.BLACK;
		} else {
			this.currentColor = currentColor;
		}

	}

	public Color getCurrentColor() {
		if (currentColor == null)
			return Color.BLACK;
		else
			return currentColor;
	}
}
