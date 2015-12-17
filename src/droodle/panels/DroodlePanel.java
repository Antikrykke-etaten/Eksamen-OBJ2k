package droodle.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import droodle.storage.StorageFacade;
import droodle.tests.STDrawingArea;

public class DroodlePanel extends JPanel {

	public static DroodleWindow dw = new DroodleWindow();
	public static StorageFacade sf = new StorageFacade();

	public static JPanel DroodlePanel = new JPanel();
	public static DroodleGUI PaintPanelGUI = new DroodleGUI();

	public DroodlePanel() {

		DroodlePanel.setLayout(new BorderLayout());
		DroodlePanel.add(DroodleGUI.PaintPanelGUI, BorderLayout.NORTH);
		DroodlePanel.add(dw, BorderLayout.CENTER);
	}
}
