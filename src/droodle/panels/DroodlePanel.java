package droodle.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class DroodlePanel extends JPanel {

	
	public static DroodleWindow dw = new DroodleWindow(10);
	public static StorageFacade sf = new StorageFacade();

	public static JPanel DroodlePanel = new JPanel();
	public static DroodleGUI PaintPanelGUI = new DroodleGUI();

	public DroodlePanel() {
		DroodlePanel.setLayout(new BorderLayout());
		DroodlePanel.add(DroodleGUI.PaintPanelGUI, BorderLayout.NORTH);
		DroodlePanel.add(dw, BorderLayout.CENTER);
	}
}
