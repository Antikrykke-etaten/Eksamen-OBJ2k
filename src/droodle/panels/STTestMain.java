package droodle.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class STTestMain extends JFrame {
	STDrawingArea drawingArea = new STDrawingArea();

	public STTestMain() {
		// JFrame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Spelling Trainer");
		setResizable(false);
		setVisible(true);

		// Panel of buttons
		JPanel buttonContainer = new JPanel();
		JButton btnRedPen = new JButton("Red Pen");
		JButton btnGreenPen = new JButton("Green Pen");
		JButton btnClear = new JButton("Clear");
		buttonContainer.add(btnRedPen);
		buttonContainer.add(btnGreenPen);
		buttonContainer.add(btnClear);
		// Drawing Area instantiation

		// Adding things to JFrame
		getContentPane().add(drawingArea);
		getContentPane().add(buttonContainer, BorderLayout.PAGE_END);
		pack();

		// button listener
		btnRedPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawingArea.setCurrentColor(Color.RED);
			}
		});

		btnGreenPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawingArea.setCurrentColor(Color.GREEN);
			}
		});

		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawingArea.clearDrawings();
			}
		});
	}

	public static void main(String args[]) {
		STTestMain test = new STTestMain();
	}

}
