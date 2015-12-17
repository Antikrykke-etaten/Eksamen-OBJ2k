package droodle.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import droodle.CardController;
import droodle.SplashScreen;

public class CreateNewProjectPanel extends JPanel {

	public static JPanel newProjectPanel = new JPanel();

	private JLabel InfoText;

	JButton createNewProjectButn = new JButton("Lag nytt prosjekt");
	JButton backToMenuButn = new JButton("Til Meny");

	JTextField projectNameField = new JTextField(30);

	public CreateNewProjectPanel() {
		Dimension Butndim = new Dimension(250, 60);
		Dimension ButndimSmal = new Dimension(130, 30);

		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		newProjectPanel.setLayout(gl);
		newProjectPanel.setBackground(Color.WHITE);

		InfoText = new JLabel("<html><br>Gi prosjektet ditt ett navn!<br> </html>", SwingConstants.CENTER);
		InfoText.setFont(new Font("Arial", Font.PLAIN, 20));

		// createNewProjectButn settings
		createNewProjectButn.setSize(Butndim);
		createNewProjectButn.setMinimumSize(Butndim);
		createNewProjectButn.setMaximumSize(Butndim);
		createNewProjectButn.setPreferredSize(Butndim);
		createNewProjectButn.setFont(new Font("Arial", Font.PLAIN, 20));
		createNewProjectButn.setEnabled(false);

		// backToMenuButn settings
		backToMenuButn.setSize(ButndimSmal);
		backToMenuButn.setMinimumSize(ButndimSmal);
		backToMenuButn.setMaximumSize(ButndimSmal);
		backToMenuButn.setPreferredSize(ButndimSmal);
		backToMenuButn.setFont(new Font("Arial", Font.PLAIN, 20));

		gbc.gridx = 0;
		gbc.gridy = 0;
		newProjectPanel.add(backToMenuButn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		newProjectPanel.add(InfoText, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		newProjectPanel.add(createNewProjectButn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		newProjectPanel.add(projectNameField, gbc);

		new Thread(target).start();

		projectNameField.addActionListener(actionListener);

		// Button actions
		createNewProjectButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardController.frame.setTitle(projectNameField.getText());
				CardController.cl.show(CardController.panelCont, "4");
			}
		});

		backToMenuButn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardController.cl.show(CardController.panelCont, "1");
			}
		});
	}

	final ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase("Enable")) {
				createNewProjectButn.setEnabled(true);
			} else if (e.getActionCommand().equalsIgnoreCase("Disable")) {
				createNewProjectButn.setEnabled(false);
			}
		}
	};

	final Runnable target = new Runnable() {
		public void run() {
			while (true) {
				final ActionListener[] listeners = projectNameField.getActionListeners();
				for (ActionListener listener : listeners) {
					if (projectNameField.getText().trim().length() > 0) {
						final ActionEvent event = new ActionEvent(projectNameField, 1, "Enable");
						listener.actionPerformed(event);
					} else {
						final ActionEvent event = new ActionEvent(projectNameField, 1, "Disable");
						listener.actionPerformed(event);
					}
				}
			}
		}
	};
}
