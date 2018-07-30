package com.toteuch.tob.ihm;

import javax.swing.JFrame;

import com.toteuch.tob.entity.TOBUser;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class TOBWindow {

	private JFrame frame;
	private TOBUser currentUser;

	/**
	 * Create the application.
	 */
	public TOBWindow(TOBUser user) {
		initialize();
		frame.setVisible(true);
		currentUser = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		ConfigOnglet configOnglet = new ConfigOnglet();
		tabbedPane.add("Configuration", configOnglet);
	}

}
