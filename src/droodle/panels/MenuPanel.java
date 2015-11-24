package droodle.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import droodle.CardController;


public class MenuPanel extends JPanel {
	
	public static JPanel menuPanel = new JPanel();
	
	private JLabel label1;
	
	JButton newProjectButn = new JButton("Lag nytt prosjekt");
	JButton oldProjectsButn = new JButton("Finn gammelt prosjekt");
	
	public  MenuPanel() {
		
		Dimension dim = new Dimension(250,60);
		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
	
		menuPanel.setLayout(gl);
		menuPanel.setBackground(Color.WHITE);
		
		label1 = new JLabel ("<html><br>Velkommen til årets applikasjon!<br> </html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		
		   		//newProjectButton settings
				newProjectButn.setSize(dim);
				newProjectButn.setMinimumSize(dim);
				newProjectButn.setMaximumSize(dim);
				newProjectButn.setPreferredSize(dim);
				newProjectButn.setFont(new Font("Arial", Font.PLAIN, 20));
				
				//oldProjectsButton settings
				oldProjectsButn.setSize(dim);
				oldProjectsButn.setMinimumSize(dim);
				oldProjectsButn.setMaximumSize(dim);
				oldProjectsButn.setPreferredSize(dim);
				oldProjectsButn.setFont(new Font("Arial", Font.PLAIN, 20));
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				menuPanel.add (label1, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				menuPanel.add(newProjectButn, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				menuPanel.add(oldProjectsButn, gbc);
				
				
				//Button actions
				newProjectButn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CardController.cl.show(CardController.panelCont, "2");
					}
				});
				
				oldProjectsButn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						CardController.cl.show(CardController.panelCont, "3");
					}
				});
	}

}

