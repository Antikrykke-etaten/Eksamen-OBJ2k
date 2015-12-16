package droodle.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class DroodlePanel extends JPanel {

	public static DroodleWindow pw = new DroodleWindow(10);
	public static JPanel DroodlePanel = new JPanel();
	public static JPanel PaintPanelGUI = new DroodleGUI();

	public DroodlePanel() {
		DroodlePanel.setLayout(new BorderLayout());
		DroodlePanel.add(DroodleGUI.PaintPanelGUI, BorderLayout.NORTH);
		DroodlePanel.add(pw, BorderLayout.CENTER);
	}
}
