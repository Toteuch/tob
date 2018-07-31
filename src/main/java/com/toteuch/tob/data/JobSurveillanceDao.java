package com.toteuch.tob.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.toteuch.tob.data.interfaces.IJobSurveillanceDao;
import com.toteuch.tob.entity.JobSurveillance;
import com.toteuch.tob.entity.TOBUser;

public class JobSurveillanceDao implements IJobSurveillanceDao {

	@Override
	public JobSurveillance saveJobSurveillance(JobSurveillance jobSurveillance) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.flush();
		session.clear();
		JobSurveillance persisted = (JobSurveillance) session.save(jobSurveillance);
		tx.commit();
		session.close();
		return persisted;
	}

	@Override
	public List<JobSurveillance> getByUser(TOBUser tobuser) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = session.createCriteria(JobSurveillance.class);
		criteria.add(Restrictions.eqOrIsNull("tobuser", tobuser));
		List<JobSurveillance> retVal = (List<JobSurveillance>) criteria.list();
		session.close();
		return retVal;
	}
	
	@Override
	public JobSurveillance getByUserAndTarget(TOBUser tobuser, String target) {
		Session session = HibernateUtils.openSession();
		Criteria criteria = session.createCriteria(JobSurveillance.class);
		criteria.add(Restrictions.eqOrIsNull("tobuser", tobuser));
		criteria.add(Restrictions.eqOrIsNull("target", target));
		JobSurveillance retVal = (JobSurveillance) criteria.uniqueResult();
		session.close();
		return retVal;
	}
	
	private JobSurveillanceDao() {
	}
	
	private static class JobSurveillanceDaoHolder {
		private final static JobSurveillanceDao instance = new JobSurveillanceDao();
	}
	
	public static JobSurveillanceDao getInstance() {
		return JobSurveillanceDaoHolder.instance;
	}
}
