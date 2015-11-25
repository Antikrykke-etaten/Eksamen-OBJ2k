package droodle.panels;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class PanelCont extends JPanel {
	
	JPanel panelCont = new JPanel();
	CardLayout cl = new CardLayout();
	
	public PanelCont() {
	panelCont.setLayout(cl);
	//Panel controll
	
	panelCont.add(new MenuPanel(), "1");
//	panelCont.add(newProjectPanel, "2");
//	panelCont.add(oldProjectsPanel, "3");
	cl.show(panelCont, "1");
	
	}

}
