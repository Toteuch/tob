package com.toteuch.tob.ihm;

import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.service.JobSurveillanceService;
import com.toteuch.tob.service.interfaces.IJobSurveillanceService;

public class JobSurveillanceOnglet extends JPanel {

	private IJobSurveillanceService jobSurveillanceService;

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
		JobSurveillanceListModel listJobModel = new JobSurveillanceListModel();
		List<JobSurveillance> listJob = jobSurveillanceService.getByUser(IHMUtils.getCurrentUser());
		if (null != listJob && !listJob.isEmpty()) {
			listJobModel.addAll((JobSurveillance[]) listJob.toArray());
			JList list = new JList(listJobModel);
			list.setBounds(10, 292, 83, -280);
			list.setVisibleRowCount(4);
			list.setEnabled(true);
			add(list);
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(118, 10, 0, 279);
		add(separator);

	}
}
