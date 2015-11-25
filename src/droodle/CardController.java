package droodle;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import droodle.panels.CreateNewProjectPanel;
import droodle.panels.GetOldProjectPanel;
import droodle.panels.MenuPanel;
import droodle.panels.PaintPanel;

public class CardController {
	JFrame frame = new JFrame("The amazing Droodler panel");
	public static JPanel panelCont = new JPanel();
	public static CardLayout cl = new CardLayout();
	
	public CardController() {
		
		new MenuPanel();
		new CreateNewProjectPanel();
		new GetOldProjectPanel();
		new PaintPanel();
		
		panelCont.setLayout(cl);
		panelCont.add(MenuPanel.menuPanel, "1");
		panelCont.add(CreateNewProjectPanel.newProjectPanel, "2");
		panelCont.add(GetOldProjectPanel.oldProjectsPanel, "3");
		panelCont.add(PaintPanel.PaintPanel, "4");
		
		cl.show(panelCont, "1");
		
		frame.setPreferredSize(new Dimension(750, 550));
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}

