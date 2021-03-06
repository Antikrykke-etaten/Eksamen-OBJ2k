package droodle.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import droodle.Configuration;
import droodle.PanelController;
import droodle.storage.StorageFacade;

public class DroodleGUI extends JPanel {
	private JLabel logo;

	private StorageFacade storageFacade;

	public static JPanel PaintPanelGUI = new JPanel();

	public DroodleGUI() {

		// HomeButnIcon
		ImageIcon menuIcon = new ImageIcon(Configuration.assetsFolder + "Menu.png");
		Image menu = menuIcon.getImage();
		Image newmenu = menu.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		menuIcon = new ImageIcon(newmenu);

		// LoadButnIcon
		ImageIcon openIcon = new ImageIcon(Configuration.assetsFolder + "load.png");
		Image open = openIcon.getImage();
		Image newOpen = open.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		openIcon = new ImageIcon(newOpen);

		// SaveButnIcon
		ImageIcon saveIcon = new ImageIcon(Configuration.assetsFolder + "Save.png");
		Image save = saveIcon.getImage();
		Image newsave = save.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		saveIcon = new ImageIcon(newsave);

		// PanelButtons
		JButton backToMenuButn = new JButton("Meny", menuIcon);
		JButton loadProjectButn = new JButton("Last inn", openIcon);
		JButton deleteButn = new JButton("Slett", saveIcon);

		// Dimensions
		Dimension PaintWindowDim = new Dimension(120, 350);
		Dimension Butndim = new Dimension(120, 40);
		Dimension ButndimSmal = new Dimension(130, 30);
		Dimension colourButtonsdim = new Dimension(120, 20);

		logo = new JLabel("", SwingConstants.LEFT);
		ImageIcon splashIcon = new ImageIcon(Configuration.assetsFolder + "droodle-logo-small.png");
		Image image = splashIcon.getImage();
		Image newimg = image.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);

		logo.setSize(50, 50);
		logo.setIcon(new ImageIcon(newimg));
		logo.setFont(new Font("Verdana", Font.BOLD, 14));

		backToMenuButn.setSize(Butndim);
		backToMenuButn.setMinimumSize(Butndim);
		backToMenuButn.setMaximumSize(Butndim);
		backToMenuButn.setPreferredSize(Butndim);
		backToMenuButn.setFont(new Font("Arial", Font.BOLD, 13));

		loadProjectButn.setSize(Butndim);
		loadProjectButn.setMinimumSize(Butndim);
		loadProjectButn.setMaximumSize(Butndim);
		loadProjectButn.setPreferredSize(Butndim);
		loadProjectButn.setFont(new Font("Arial", Font.BOLD, 13));

		deleteButn.setSize(Butndim);
		deleteButn.setMinimumSize(Butndim);
		deleteButn.setMaximumSize(Butndim);
		deleteButn.setPreferredSize(Butndim);
		deleteButn.setFont(new Font("Arial", Font.BOLD, 13));

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		PaintPanelGUI.setBackground(new Color(196, 215, 233));
		PaintPanelGUI.setLayout(gl);

		gbc.gridx = 0;
		gbc.gridy = 0;
		PaintPanelGUI.add(logo, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		PaintPanelGUI.add(backToMenuButn, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		PaintPanelGUI.add(loadProjectButn, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		PaintPanelGUI.add(deleteButn, gbc);

		// Button actions
		backToMenuButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DroodlePanel.dw.clearDrawings();
				PanelController.cl.show(PanelController.panelCont, "1");
			}
		});

		loadProjectButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DroodlePanel.dw.clearDrawings();
				PanelController.lp.setup();
				PanelController.cl.show(PanelController.panelCont, "3");
			}
		});

		deleteButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				DroodlePanel.dw.clearDrawings();
			}
		});

	}
}
