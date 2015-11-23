package droodle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class CardController {
	//Frame
	JFrame frame = new JFrame("The amazing Droodler panel");
	
	//Panels
	JPanel panelCont = new JPanel();
	JPanel menuPanel = new JPanel();
	JPanel newProjectPanel = new JPanel();
	JPanel oldProjectsPanel = new JPanel();
	
	//Buttons
	JButton newProjectButn = new JButton("Nytt prosjekt");
	JButton oldProjectsButn = new JButton("Last inn prosjekt");
	JButton createNewProjectButn = new JButton("Nytt prosjekt");
	JButton backToMenuButn2 = new JButton("Til Meny");
	JButton backToMenuButn1 = new JButton("Til Meny");
	
	//Layout
	CardLayout cl = new CardLayout();
	GridBagLayout gl = new GridBagLayout();
	
	
	//Labels
	private JLabel label1;
	


	public CardController() {
		
		Dimension dim = new Dimension(250,60);
		Dimension dimSmal = new Dimension(130,30);
		
		
		panelCont.setLayout(cl);
		
		menuPanel.setLayout(gl);
		newProjectPanel.setLayout(gl);
		oldProjectsPanel.setLayout(gl);
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		
		//First panel "Menu"
		menuPanel.setBackground(Color.WHITE);
		
		label1 = new JLabel ("<html><br>Velkommen til årets applikasjon!<br> </html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		menuPanel.add (label1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		menuPanel.add(newProjectButn, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		menuPanel.add(oldProjectsButn, gbc);
		
		//Second panel "Create new project"
		newProjectPanel.setBackground(Color.WHITE);
		
		label1 = new JLabel ("<html><br>Gi det nye prosjektet ett navn!<br></html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		newProjectPanel.add (label1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		newProjectPanel.add(backToMenuButn1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		newProjectPanel.add(createNewProjectButn, gbc );
		
	   // Drawsome Drawsome = new Drawsome("Et lite tegneprogram");
	   // newProjectPanel.add(Drawsome);
		
		//Third panel "Select old project"
		oldProjectsPanel.setBackground(Color.WHITE);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		oldProjectsPanel.add(backToMenuButn2, gbc);
		
		label1 = new JLabel ("<html><br>Velg blant dine gamle prosjekter!<br></html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		oldProjectsPanel.add (label1, gbc);
		
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
		
		//createNewProjectButn settings
		createNewProjectButn.setSize(dim);
		createNewProjectButn.setMinimumSize(dim);
		createNewProjectButn.setMaximumSize(dim);
		createNewProjectButn.setPreferredSize(dim);
		createNewProjectButn.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//backToMenuButn settings
		backToMenuButn1.setSize(dimSmal);
		backToMenuButn1.setMinimumSize(dimSmal);
		backToMenuButn1.setMaximumSize(dimSmal);
		backToMenuButn1.setPreferredSize(dimSmal);
		backToMenuButn1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		backToMenuButn2.setSize(dimSmal);
		backToMenuButn2.setMinimumSize(dimSmal);
		backToMenuButn2.setMaximumSize(dimSmal);
		backToMenuButn2.setPreferredSize(dimSmal);
		backToMenuButn2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//Panel controll
		panelCont.add(menuPanel, "1");
		panelCont.add(newProjectPanel, "2");
		panelCont.add(oldProjectsPanel, "3");
		cl.show(panelCont, "1");
		
		
		//Button actions
		newProjectButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
			}
		});
		
		oldProjectsButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			}
		});
		
		createNewProjectButn .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});
		
		backToMenuButn1 .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		backToMenuButn2 .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		
		frame.setPreferredSize(new Dimension(350, 350));
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}