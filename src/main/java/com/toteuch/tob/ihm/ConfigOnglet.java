package com.toteuch.tob.ihm;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigOnglet extends JPanel {
	private JTextField tfScreenshotFilepath;

	/**
	 * Create the panel.
	 */
	public ConfigOnglet() {
		setLayout(null);
		
		JLabel lblScreenshotFilepath = new JLabel("Screenshot filepath :");
		lblScreenshotFilepath.setBounds(10, 11, 100, 14);
		add(lblScreenshotFilepath);
		
		tfScreenshotFilepath = new JTextField();
		tfScreenshotFilepath.setBounds(120, 8, 86, 20);
		add(tfScreenshotFilepath);
		tfScreenshotFilepath.setColumns(10);
		
		JButton btnSetMouseCoords = new JButton("Set Mouse Coords");
		btnSetMouseCoords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSetMouseCoordsEvent();
			}
		});
		btnSetMouseCoords.setBounds(10, 36, 196, 23);
		add(btnSetMouseCoords);

	}
	
	private void btnSetMouseCoordsEvent() {
		ConfigMouseCoordWindow cmcw = new ConfigMouseCoordWindow();
		cmcw.setVisible(true);
	}
}
