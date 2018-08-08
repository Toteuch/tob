package com.toteuch.tob.ihm;

import javax.swing.JFrame;

import com.toteuch.tob.entity.TOBUser;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class TOBWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public TOBWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		ConfigOnglet configOnglet = new ConfigOnglet();
		tabbedPane.add("Configuration", configOnglet);
		
		JobSurveillanceOnglet jobSurveillanceOnglet = new JobSurveillanceOnglet();
		tabbedPane.add("Job Surveillance", jobSurveillanceOnglet);
	}

}
