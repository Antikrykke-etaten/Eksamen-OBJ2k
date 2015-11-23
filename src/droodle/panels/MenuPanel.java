package droodle.panels;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	public JPanel MenuPanel() {
		
		JPanel menuPanel = new JPanel();
		
		GridBagLayout gl = new GridBagLayout();
		menuPanel.setLayout(gl);
		
		return menuPanel;
		
	}

}
