package droodle.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import droodle.CardController;
import droodle.Configuration;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel logo;
	static PaintWindowPanel pw = new PaintWindowPanel(10);
	
	public static JPanel PaintPanel = new JPanel();
	static JPanel PaintPanelWindow = pw;
	JPanel PaintPanelGUI = new GUIPanel();

	public PaintPanel() {

		//GridBagLayout gl = new GridBagLayout();
		//GridBagConstraints gbc = new GridBagConstraints();
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.insets = new Insets(5, 5, 5, 5);

		// Panels
		//PaintPanelWindow.setBackground(Color.GRAY);
		//Border Windowborder = BorderFactory.createLineBorder(Color.WHITE, 20);
		
		//PaintPanel.setBackground(Color.GRAY);
		PaintPanel.setLayout(new BorderLayout());
		PaintPanel.add(GUIPanel.PaintPanelGUI, BorderLayout.NORTH);
		//PaintPanel.add(PaintPanelGUI, BorderLayout.NORTH);
		PaintPanel.add(PaintPanelWindow, BorderLayout.CENTER);
		//PaintPanelWindow.setBorder(Windowborder);
		
	


	}
}
