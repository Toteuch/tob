package com.toteuch.tob.ihm;

import java.awt.List;

import javax.swing.JPanel;

import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.service.JobSurveillanceService;
import com.toteuch.tob.service.interfaces.IJobSurveillanceService;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Button;

public class JobSurveillanceOnglet extends JPanel {

	private IJobSurveillanceService jobSurveillanceService;

	private List listJobAwt;
	private JTextField tfTarget;
	private JTextField tfWaitTime;
	private JTextField tfStartHour;
	private JTextField tfEndHour;
	
	/**
	 * Create the panel.
	 */
	public JobSurveillanceOnglet() {
		setLayout(null);

		
		

		try {
			jobSurveillanceService = JobSurveillanceService.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.List<JobSurveillance> listJob = jobSurveillanceService.getByUser(IHMUtils.getCurrentUser());
		listJobAwt = new List();
		listJobAwt.setBounds(10, 10, 110, 226);
		if (null != listJob && !listJob.isEmpty()) {
			for (JobSurveillance job : listJob) {
				listJobAwt.add(job.toString());
			}
		}
		add(listJobAwt);
		
		tfTarget = new JTextField();
		tfTarget.setBounds(219, 11, 86, 20);
		add(tfTarget);
		tfTarget.setColumns(10);
		
		Label label = new Label("Target");
		label.setAlignment(Label.RIGHT);
		label.setBounds(126, 10, 87, 22);
		add(label);
		
		tfWaitTime = new JTextField();
		tfWaitTime.setBounds(219, 42, 43, 20);
		add(tfWaitTime);
		tfWaitTime.setColumns(10);
		
		JLabel lblSec = new JLabel("sec.");
		lblSec.setBounds(272, 45, 33, 14);
		add(lblSec);
		
		Label label_1 = new Label("Temps d'attente");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(126, 40, 87, 22);
		add(label_1);
		
		JLabel lblHeureDeDbut = new JLabel("Heure de début");
		lblHeureDeDbut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeureDeDbut.setBounds(315, 14, 75, 14);
		add(lblHeureDeDbut);
		
		tfStartHour = new JTextField();
		tfStartHour.setText("21:00:00");
		tfStartHour.setToolTipText("hh:mm:ss");
		tfStartHour.setColumns(10);
		tfStartHour.setBounds(400, 11, 86, 20);
		add(tfStartHour);
		
		JLabel lblHeureDeFin = new JLabel("Heure de fin");
		lblHeureDeFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeureDeFin.setBounds(315, 45, 75, 14);
		add(lblHeureDeFin);
		
		tfEndHour = new JTextField();
		tfEndHour.setText("08:00:00");
		tfEndHour.setToolTipText("hh:mm:ss");
		tfEndHour.setColumns(10);
		tfEndHour.setBounds(400, 42, 86, 20);
		add(tfEndHour);
		
		Label label_2 = new Label("Systèmes");
		label_2.setBounds(328, 65, 62, 22);
		add(label_2);
		
		List systemList = new List();
		systemList.setBounds(302, 93, 110, 143);
		add(systemList);
		
		Label label_3 = new Label("Ajouter un système");
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(126, 93, 170, 22);
		add(label_3);
		
		TextField tfGalaxy = new TextField();
		tfGalaxy.setText("7");
		tfGalaxy.setBounds(189, 121, 24, 22);
		add(tfGalaxy);
		
		Label label_4 = new Label(":");
		label_4.setBounds(213, 121, 6, 22);
		add(label_4);
		
		TextField tfSystem = new TextField();
		tfSystem.setText("499");
		tfSystem.setBounds(221, 121, 33, 22);
		add(tfSystem);
		
		Button btnAddSystem = new Button("Add");
		btnAddSystem.setBounds(189, 147, 56, 22);
		add(btnAddSystem);
		
		Button btnDeleteSystem = new Button("Delete");
		btnDeleteSystem.setBounds(418, 147, 56, 22);
		add(btnDeleteSystem);
	}
}
