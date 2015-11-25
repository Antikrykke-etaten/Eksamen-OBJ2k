package droodle.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelCont extends JPanel {
	

	CardLayout cl = new CardLayout();
	
	
	public  PanelCont() {
	
	JPanel panelCont = new JPanel();
	CardLayout cl = new CardLayout();
	
	panelCont.setLayout(cl);
	panelCont.setBackground(Color.BLACK);
	panelCont.setPreferredSize(new Dimension(220, 40));
	//Panel controll
	
	System.out.println("Cont");
	//panelCont.add (new MenuPanel());
	panelCont.add(new MenuPanel(), "1");
//	panelCont.add(newProjectPanel, "2");
//	panelCont.add(oldProjectsPanel, "3");
	cl.show(panelCont, "1");
	 
	
	}
	
	

}
