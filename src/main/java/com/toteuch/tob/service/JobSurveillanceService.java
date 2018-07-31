package com.toteuch.tob.service;

import java.util.List;

import com.toteuch.tob.data.JobSurveillanceDao;
import com.toteuch.tob.data.interfaces.IJobSurveillanceDao;
import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.entity.TOBUser;
import com.toteuch.tob.service.interfaces.IJobSurveillanceService;

public class JobSurveillanceService implements IJobSurveillanceService {

	private IJobSurveillanceDao jobSurveillanceDao;
	
	@Override
	public JobSurveillance saveJobSurveillance(JobSurveillance jobSurveillance) {
		JobSurveillance retVal = null;
		if(null != jobSurveillance.getId()) {
			retVal = jobSurveillanceDao.saveJobSurveillance(jobSurveillance);
		} else {
			JobSurveillance inDb = jobSurveillanceDao.getByUserAndTarget(jobSurveillance.getTobuser(), jobSurveillance.getTarget());
			inDb.setEndTime(jobSurveillance.getEndTime());
			inDb.setStartTime(jobSurveillance.getStartTime());
			inDb.setIsActive(jobSurveillance.getIsActive());
			inDb.setSystemMap(jobSurveillance.getSystemMap());
			inDb.setWaitBetweenSS(jobSurveillance.getWaitBetweenSS());
			retVal = jobSurveillanceDao.saveJobSurveillance(inDb);
		}
		return retVal;		
	}
	
	@Override
	public List<JobSurveillance> getByUser(TOBUser tobuser) {
		List<JobSurveillance> retVal = jobSurveillanceDao.getByUser(tobuser);
		if(null == retVal || retVal.isEmpty()) {
			return null;
		}
		return retVal;
	}

	@Override
	public JobSurveillance getByUserAndTarget(TOBUser tobuser, String target) {
		return jobSurveillanceDao.getByUserAndTarget(tobuser, target);
	}

	private JobSurveillanceService() {
		jobSurveillanceDao = JobSurveillanceDao.getInstance();
	}
	
	private static class JobSurveillanceServiceHolder {
		private static JobSurveillanceService instance = new JobSurveillanceService();
	}
	
	public static JobSurveillanceService getInstance() throws Exception {
		return JobSurveillanceServiceHolder.instance;
	}
}
