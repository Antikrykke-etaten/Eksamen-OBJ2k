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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import droodle.Droodle;
import droodle.PanelController;

@SuppressWarnings("serial")
public class LoadPanel extends JPanel {

	public static JPanel oldProjectsPanel = new JPanel();
	private JLabel label1;

	JList list;
	DefaultListModel model;

	JButton backToMenuButn = new JButton("Til Meny");
	JButton LoadSketchButn = new JButton("Last inn tegning");
	JButton DeleteOneFileButn = new JButton("Slett tegning");

	public LoadPanel() {
		model = new DefaultListModel();
		list = new JList(model);
		JScrollPane pane = new JScrollPane(list);

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

		gbc.gridx = 0;
		gbc.gridy = 4;
		oldProjectsPanel.add(DeleteOneFileButn, gbc);

		disableButtons();

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
				reset();
				PanelController.cl.show(PanelController.panelCont, "1");
			}
		});

		DeleteOneFileButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if (index >= 0) {
					String a = list.getSelectedValue().toString();
					DroodlePanel.sf.deleteFile(a);
					model.removeElementAt(index);
				}

				if (list.getModel().getSize() < 1) {
					disableButtons();
				}

			}
		});

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				enableButtons();
			}

		});

		// Load selected sketch buttonAction
		LoadSketchButn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(list.getSelectedValue());
				String a = list.getSelectedValue().toString();
				DroodlePanel.sf.sketchName = a;
				PanelController.frame.setTitle(a);
				reset();
				for (String f : Droodle.storage.getFilenames()) {
					if (f.equals(DroodlePanel.sf.sketchName)) {
						try {
							DroodlePanel.sf.LoadPoints();
							PanelController.cl.show(PanelController.panelCont, "4");
						} catch (IOException e) {
							PanelController.cl.show(PanelController.panelCont, "3");
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return;
					}
				}
			}
		});
	}

	public void reset() {
		disableButtons();

		model.removeAllElements();
	}

	public void disableButtons() {
		LoadSketchButn.setEnabled(false);
		DeleteOneFileButn.setEnabled(false);
	}

	public void enableButtons() {
		LoadSketchButn.setEnabled(true);
		DeleteOneFileButn.setEnabled(true);
	}

	public void setup() {
		for (String f : Droodle.storage.getFilenames()) {
			model.addElement(f);
		}
	}
}
