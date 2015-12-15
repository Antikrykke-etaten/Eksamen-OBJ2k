package droodle.panels;

import java.awt.BorderLayout;
import storagetool.Storage;
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

public class DroodlePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel logo;
	static DroodleWindow pw = new DroodleWindow(10);
	
	public static JPanel DroodlePanel = new JPanel();
	static JPanel DroodleWindow = pw;
	JPanel PaintPanelGUI = new DroodleGUI();

	public DroodlePanel() {

		//GridBagLayout gl = new GridBagLayout();
		//GridBagConstraints gbc = new GridBagConstraints();
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.insets = new Insets(5, 5, 5, 5);

		// Panels
		//PaintPanelWindow.setBackground(Color.GRAY);
		//Border Windowborder = BorderFactory.createLineBorder(Color.WHITE, 20);
		
		//PaintPanel.setBackground(Color.GRAY);
		DroodlePanel.setLayout(new BorderLayout());
		DroodlePanel.add(DroodleGUI.PaintPanelGUI, BorderLayout.NORTH);
		//PaintPanel.add(PaintPanelGUI, BorderLayout.NORTH);
		DroodlePanel.add(DroodleWindow, BorderLayout.CENTER);
		//PaintPanelWindow.setBorder(Windowborder);
		
	


	}
}
