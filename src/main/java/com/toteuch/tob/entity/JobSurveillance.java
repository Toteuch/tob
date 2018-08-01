package com.toteuch.tob.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.StringUtils;

@Entity
public class JobSurveillance implements Serializable, Comparable<JobSurveillance> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="jobsurveillance_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tobuser_id")
	private TOBUser tobuser;
	
	private String target;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "jobsurveillance_gamesystem", 
	        joinColumns = { @JoinColumn(name = "jobsurveillance_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "gamesystem_id") }
	    )
	private List<GameSystem> gameSystemList;
	private Duration startTime;
	private Duration endTime;
	private Integer waitBetweenSS;
	private Boolean isActive;
	public Long getId() {
		return id;
	}
	public TOBUser getTobuser() {
		return tobuser;
	}
	public String getTarget() {
		return target;
	}
	public List<GameSystem> getSystemMap() {
		return gameSystemList;
	}
	public Duration getStartTime() {
		return startTime;
	}
	public Duration getEndTime() {
		return endTime;
	}
	public Integer getWaitBetweenSS() {
		return waitBetweenSS;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTobuser(TOBUser tobuser) {
		this.tobuser = tobuser;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public void setSystemMap(List<GameSystem> gameSystemList) {
		this.gameSystemList = gameSystemList;
	}
	public void setStartTime(Duration startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Duration endTime) {
		this.endTime = endTime;
	}
	public void setWaitBetweenSS(Integer waitBetweenSS) {
		this.waitBetweenSS = waitBetweenSS;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public int hashCode() {
		int result;
		result = tobuser.hashCode();
		result = result + target.hashCode();
		result = 29 * result + getId().intValue();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof JobSurveillance) {
			JobSurveillance other = (JobSurveillance) obj;
			if(this.id == other.getId() 
					|| (StringUtils.equals(tobuser.getLogin(), other.tobuser.getLogin()) 
							&& StringUtils.equals(target, other.target))) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public int compareTo(JobSurveillance arg0) {
		return this.hashCode() - arg0.hashCode();
	}
	
	@Override
	public String toString() {
		return this.target;
	}
}
