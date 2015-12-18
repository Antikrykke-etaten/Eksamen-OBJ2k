package droodle;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


import droodle.panels.CreatePanel;
import droodle.panels.DroodlePanel;
import droodle.panels.LoadPanel;
import droodle.panels.MenuPanel;

public class PanelController {
	public static JFrame frame = new JFrame("The amazing Droodler panel");
	public static JPanel panelCont = new JPanel();
	public static CardLayout cl = new CardLayout();
	public static CreatePanel cp = new CreatePanel();
	public static LoadPanel lp = new LoadPanel();
	public static DroodlePanel dp = new DroodlePanel();

	public PanelController() {

		new MenuPanel();
		

		panelCont.setLayout(cl);
		panelCont.add(MenuPanel.menuPanel, "1");
		panelCont.add(cp.newProjectPanel, "2");
		panelCont.add(lp.oldProjectsPanel, "3");
		panelCont.add(dp.DroodlePanel, "4");

		cl.show(panelCont, "1");

		frame.setPreferredSize(new Dimension(750, 550));
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
