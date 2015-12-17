package droodle.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DroodleWindow extends JPanel implements Serializable {

	private static final int DA_WIDTH = 4000;
	private static final int DA_HEIGHT = 4000;
	private static final Color DA_BGCOLOR = Color.WHITE;
	private static final long serialVersionUID = 1L;

	ArrayList<Point> points = new ArrayList<Point>();

	private Color currentColor;
	transient BufferedImage bImage = new BufferedImage(DA_WIDTH, DA_HEIGHT, BufferedImage.TYPE_INT_RGB);

	public DroodleWindow() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		// Basic Settings for bImage
		Graphics g2d = bImage.getGraphics();
		Graphics2D g2 = (Graphics2D) g2d;
		g2.drawRenderedImage(bImage, null);
		g2.setColor(DA_BGCOLOR);
		g2.fillRect(0, 0, DA_WIDTH, DA_HEIGHT);
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
				System.out.println("mouseReleased X: " + e.getX() + "mouseReleased Y: " + e.getY());
				repaint();
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DA_WIDTH, DA_HEIGHT);
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
			g.fillRect(0, 0, DA_WIDTH, DA_WIDTH);
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
