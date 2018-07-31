package com.toteuch.tob.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name="configxy", uniqueConstraints= {@UniqueConstraint(columnNames = {"tobuser_id", "label"})})
public class ConfigXY implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="configxy_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tobuser_id")
	private TOBUser tobuser;
	private String label;
	@Column(name="coordx")
	private int x;
	@Column(name="coordy")
	private int y;
	
	public ConfigXY() {
		
	}
	
	public ConfigXY(TOBUser tobUser, String label, int x, int y) {
		this.tobuser = tobUser;
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public Long getId() {
		return id;
	}

	public TOBUser getTobUser() {
		return tobuser;
	}

	public String getLabel() {
		return label;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTobUser(TOBUser tobUser) {
		this.tobuser = tobUser;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof ConfigXY) {
			ConfigXY conf = (ConfigXY) other;
			if(this.id == conf.getId() || (this.tobuser.equals(conf.getTobUser()) && StringUtils.equals(this.label, conf.label))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
        int result;
        result = getTobUser().hashCode();
        result = 29 * result + getId().intValue();
        return result;
	}
}
