package com.toteuch.tob.ihm;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.toteuch.tob.entity.GameSystem;
import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.service.JobSurveillanceService;
import com.toteuch.tob.service.interfaces.IJobSurveillanceService;

public class JobSurveillanceOnglet extends JPanel {

	private IJobSurveillanceService jobSurveillanceService;

	private List listJobAwt;
	private JTextField tfTarget;
	private JTextField tfWaitTime;
	private JTextField tfStartHour;
	private JTextField tfEndHour;
	private List systemList;
	private TextField tfGalaxy;
	private TextField tfSystem;
	private Button btnAddSystem;
	private Button btnDeleteSystem;
	private JCheckBox chckbxIsActif;
	
	private JobSurveillance loadedJob;
	
	private void initLayout() {
		listJobAwt = new List();
		listJobAwt.setBounds(10, 10, 110, 269);
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
		lblHeureDeDbut.setBounds(315, 13, 98, 14);
		add(lblHeureDeDbut);

		tfStartHour = new JTextField();
		tfStartHour.setToolTipText("hh:mm:ss");
		tfStartHour.setColumns(10);
		tfStartHour.setBounds(423, 10, 86, 20);
		add(tfStartHour);

		JLabel lblHeureDeFin = new JLabel("Heure de fin");
		lblHeureDeFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeureDeFin.setBounds(315, 44, 98, 14);
		add(lblHeureDeFin);

		tfEndHour = new JTextField();
		tfEndHour.setToolTipText("hh:mm:ss");
		tfEndHour.setColumns(10);
		tfEndHour.setBounds(423, 41, 86, 20);
		add(tfEndHour);

		Label label_2 = new Label("Systèmes");
		label_2.setBounds(328, 65, 62, 22);
		add(label_2);

		systemList = new List();
		systemList.setBounds(302, 93, 110, 186);
		add(systemList);

		Label label_3 = new Label("Ajouter un système");
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(126, 93, 170, 22);
		add(label_3);

		tfGalaxy = new TextField();
		tfGalaxy.setBounds(175, 121, 24, 22);
		add(tfGalaxy);

		Label label_4 = new Label(":");
		label_4.setBounds(199, 121, 6, 22);
		add(label_4);

		tfSystem = new TextField();
		tfSystem.setBounds(207, 121, 33, 22);
		add(tfSystem);

		btnAddSystem = new Button("Add");
		btnAddSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSystem();
			}
		});
		btnAddSystem.setBounds(175, 147, 56, 22);
		add(btnAddSystem);

		btnDeleteSystem = new Button("Delete");
		btnDeleteSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteSystem();
			}
		});
		btnDeleteSystem.setBounds(441, 146, 56, 22);
		add(btnDeleteSystem);

		chckbxIsActif = new JCheckBox("Actif");
		chckbxIsActif.setBounds(423, 93, 69, 23);
		add(chckbxIsActif);

		JLabel lbldefauts = new JLabel("(defaut : 5s)");
		lbldefauts.setBounds(136, 68, 77, 14);
		add(lbldefauts);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveJob();
			}
		});
		btnSave.setBounds(126, 175, 170, 23);
		add(btnSave);
		
		JButton btnDiscardChanges = new JButton("Discard changes");
		btnDiscardChanges.setBounds(126, 209, 170, 23);
		add(btnDiscardChanges);
		
		JButton btnNouveauJob = new JButton("Nouveau job");
		btnNouveauJob.setBounds(126, 243, 170, 23);
		add(btnNouveauJob);
	}

	/**
	 * Create the panel.
	 */
	public JobSurveillanceOnglet() {
		// Init
		setLayout(null);
		jobSurveillanceService = JobSurveillanceService.getInstance();

		// SetLayout
		initLayout();

		// Data
		java.util.List<JobSurveillance> listJob = jobSurveillanceService.getByUser(IHMUtils.getCurrentUser());
		if (null != listJob && !listJob.isEmpty()) {
			for (JobSurveillance job : listJob) {
				listJobAwt.add(job.toString());
			}
			JobSurveillance job = listJob.get(0);
			this.listJobAwt.select(0);
			setDataFromJob(job);
		}
	}

	private void setDataFromJob(JobSurveillance job) {
		this.loadedJob = job;
		this.tfTarget.setText(job.getTarget());
		Date startTime = job.getStartTime();
		Date endTime = job.getEndTime();
		Boolean isActive = job.getIsActive();
		Integer waitTime = job.getWaitBetweenSS();
		java.util.List<GameSystem> listSystem = job.getSystemMap();
		if (null != startTime) {
			this.tfStartHour.setText(IHMUtils.getHoursSDF().format(startTime));
		} else {
			this.tfStartHour.setText(null);
		}

		if (null != endTime) {
			this.tfEndHour.setText(IHMUtils.getHoursSDF().format(endTime));
		} else {
			this.tfEndHour.setText(null);
		}

		if (BooleanUtils.isTrue(isActive)) {
			this.chckbxIsActif.setSelected(true);
		} else {
			this.chckbxIsActif.setSelected(false);
		}

		if (null == waitTime) {
			waitTime = 5;
		}
		this.tfWaitTime.setText(waitTime.toString());

		for (GameSystem system : listSystem) {
			this.systemList.add(system.toString());
		}
	}

	private void addSystem() {
		try {
			Integer galaxy = Integer.parseInt(this.tfGalaxy.getText());
			Integer system = Integer.parseInt(this.tfSystem.getText());
			if (galaxy > 0 && galaxy <= 7 && system > 0 && system <= 499) {
				GameSystem gsystem = new GameSystem();
				gsystem.setGalaxy(galaxy);
				gsystem.setSystem(system);
				this.loadedJob.getSystemMap().add(gsystem);
				this.systemList.add(gsystem.toString());
			} else {
				JOptionPane.showMessageDialog(this, "Impossible d'ajouter le système");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Format du système incorrect");
		}
	}
	
	private void deleteSystem() {
		try {
			String selectedSystem = this.systemList.getSelectedItem();
			for(GameSystem loadedSystem : this.loadedJob.getSystemMap()) {
				if(StringUtils.equals(loadedSystem.toString(), selectedSystem)) {
					this.loadedJob.getSystemMap().remove(loadedSystem);
					break;
				}
			}
			this.systemList.remove(this.systemList.getSelectedIndex());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Impossible de supprimer le système");
		}
	}
	
	private void saveJob() {
		try {
			String target = this.tfTarget.getText();
			String startTime = this.tfStartHour.getText();
			String endTime = this.tfEndHour.getText();
			String waitTime = this.tfWaitTime.getText();
			
			if(StringUtils.isNotBlank(target)) {
				this.loadedJob.setTarget(target);
			} else {
				JOptionPane.showMessageDialog(this, "La target est obligatoire");
			}
			if(StringUtils.isNotBlank(startTime)) {
				try {
					this.loadedJob.setStartTime(IHMUtils.getHoursSDF().parse(startTime));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Format d'heure de début invalide (hh:mm:ss)");
				}
			}
			if(StringUtils.isNotBlank(endTime)) {
				try {
					this.loadedJob.setEndTime(IHMUtils.getHoursSDF().parse(endTime));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Format d'heure de fin invalide (hh:mm:ss)");
				}
			}
			int wait = 5; 
			if(StringUtils.isNotBlank(waitTime)) {
				try {
					wait = Integer.parseInt(waitTime);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Format d'attente inccorect (numérique)");
				}
				this.loadedJob.setWaitBetweenSS(wait);
			} 
			this.loadedJob.setIsActive(this.chckbxIsActif.isSelected());
			this.jobSurveillanceService.saveJobSurveillance(this.loadedJob);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace().toString());
			JOptionPane.showMessageDialog(this, "Erreur lors de la sauvegarde.");
		}
	}
}