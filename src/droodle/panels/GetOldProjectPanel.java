package droodle.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.microsoft.azure.storage.StorageException;

import droodle.CardController;
import droodle.Droodle;
import storagetool.Storage;

public class GetOldProjectPanel extends JPanel {

	public static JPanel oldProjectsPanel = new JPanel();
	private JLabel label1;

	JList list;
	DefaultListModel model;
	int counter = 0;
	 
	 JButton backToMenuButn = new JButton("Til Meny");
	 JButton LoadSketchButn = new JButton("Load sketch");

	 public GetOldProjectPanel() {
		
		model = new DefaultListModel();
	    list = new JList(model);
	    JScrollPane pane = new JScrollPane(list);
	    
	    for (int i = 0; i < 0; i++)
	        model.addElement("Element " + i);

		Dimension Butndim = new Dimension(250, 60);
		Dimension ButndimSmal = new Dimension(130, 30);

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		oldProjectsPanel.setLayout(gl);
		oldProjectsPanel.setBackground(Color.WHITE);

		label1 = new JLabel("<html><br>Gi prosjektet ditt ett navn!<br> </html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 20));

		gbc.gridx = 0;
		gbc.gridy = 0;
		oldProjectsPanel.add(backToMenuButn, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		oldProjectsPanel.add(pane, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		oldProjectsPanel.add(LoadSketchButn, gbc);

		label1 = new JLabel("<html><br>Velg blant dine gamle prosjekter!<br></html>", SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 20));

		gbc.gridx = 0;
		gbc.gridy = 1;
		oldProjectsPanel.add(label1, gbc);

		// Butn settings
		backToMenuButn.setSize(ButndimSmal);
		backToMenuButn.setMinimumSize(ButndimSmal);
		backToMenuButn.setMaximumSize(ButndimSmal);
		backToMenuButn.setPreferredSize(ButndimSmal);
		backToMenuButn.setFont(new Font("Arial", Font.PLAIN, 20));

		// Butn actions
		backToMenuButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardController.cl.show(CardController.panelCont, "1");
			}
		});
		
		//Droodle.storage = new Storage("sketches-6");
		System.out.println("hey! ");
		for (String f:Droodle.storage.getFilenames()) {
			model.addElement(f);
	        counter++;
			System.out.println("Sketch file: " + f);
		}
		
		LoadSketchButn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        System.out.println(list.getSelectedValue());
		        String a = list.getSelectedValue().toString();
		        DroodlePanel.sf.sketchName = a;
		        
		        if(a != null && !a.isEmpty()){
		        	 System.out.println("Velg sketch");
		        	return;	
		        }
		        
		        for (String f:Droodle.storage.getFilenames()) {
					if(f.equals(DroodlePanel.sf.sketchName)){
						try {
							DroodlePanel.sf.LoadSketch();
							CardController.cl.show(CardController.panelCont, "4");
						} catch (URISyntaxException | StorageException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						return;
					}
						DroodlePanel.sf.newSketch();
					
				}
		      }
		    });
	}
	 
	 public void addToList() {
		 
	 }
}
