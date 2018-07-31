package com.toteuch.tob.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toteuch.tob.entity.TOBUser;
import javax.swing.JTextPane;

public class ConfigOnglet extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public ConfigOnglet() {
		setLayout(null);
		
		JButton btnSetMouseCoords = new JButton("Set Mouse Coords");
		btnSetMouseCoords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnSetMouseCoordsEvent();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSetMouseCoords.setBounds(244, 11, 196, 23);
		add(btnSetMouseCoords);
		
		JTextPane txtpnBlabla = new JTextPane();
		txtpnBlabla.setText("blabla");
		txtpnBlabla.setBounds(10, 11, 224, 278);
		add(txtpnBlabla);

	}
	
	private void btnSetMouseCoordsEvent() throws Exception {
		ConfigMouseCoordWindow cmcw = new ConfigMouseCoordWindow();
		cmcw.setVisible(true);
	}
}
