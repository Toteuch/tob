package com.toteuch.tob.data.interfaces;

import java.util.List;

import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.entity.TOBUser;

public interface IJobSurveillanceDao {
	public JobSurveillance saveJobSurveillance(JobSurveillance jobSurveillance);
	public List<JobSurveillance> getByUser(TOBUser tobuser);
	public JobSurveillance getByUserAndTarget(TOBUser tobuser, String target);
}
