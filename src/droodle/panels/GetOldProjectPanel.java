package droodle.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import droodle.CardController;
import droodle.Droodle;
import storagetool.Storage;

public class GetOldProjectPanel extends JPanel {

	public static JPanel oldProjectsPanel = new JPanel();
	private JLabel label1;

	JList list;
	DefaultListModel<Object> model;

	JButton backToMenuButn = new JButton("Til Meny");

	@SuppressWarnings("unchecked")
	public GetOldProjectPanel() {

		model = new DefaultListModel<Object>();
		list = new JList(model);
		JScrollPane pane = new JScrollPane(list);

		for (int i = 0; i < 15; i++)
			model.addElement("Element " + i);

		Dimension Butndim = new Dimension(250, 60);
		Dimension ButndimSmal = new Dimension(130, 30);

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		oldProjectsPanel.setLayout(gl);
		oldProjectsPanel.setBackground(Color.WHITE);

		gbc.gridx = 0;
		gbc.gridy = 0;
		oldProjectsPanel.add(backToMenuButn, gbc);

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

		// Droodle.storage = new Storage("sketches-6");
		System.out.println("hey! ");
		for (String f : Droodle.storage.getFilenames()) {
			System.out.println("Sketch file: " + f);
		}
	}

	public void addToList() {

	}
}
