package droodle;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Drawsome extends JPanel implements MouseMotionListener {
	private int drawStroke = 1;
	
	public Drawsome(int strokeSize) {
		addMouseMotionListener(this);
		this.drawStroke=strokeSize;
	}

	public void mouseDragged(MouseEvent evt) {
		start = slutt;
		slutt = new Point(evt.getX(), evt.getY());
		repaint();
	}

	public void mouseMoved(MouseEvent evt) {
		slutt = null;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(drawStroke));
		if (slutt != null && start != null)
			g2.drawLine(start.x, start.y, slutt.x, slutt.y);

	}

	public void update(Graphics g) {
		paint(g);
	}

	Point start = null;
	Point slutt = null;

}

