package com.toteuch.tob.service.interfaces;

import java.util.List;

import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.entity.TOBUser;

public interface IJobSurveillanceService {
	public List<JobSurveillance> getByUser(TOBUser tobuser);
	public void  saveJobSurveillance(JobSurveillance jobSurveillance);
	public JobSurveillance getByUserAndTarget(TOBUser tobuser, String target);
}
