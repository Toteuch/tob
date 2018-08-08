package com.toteuch.tob.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameSystem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gamesystem_id")
	private Long id;
	
	public Integer galaxy;
	public Integer system;

	public Integer getGalaxy() {
		return galaxy;
	}

	public Integer getSystem() {
		return system;
	}

	public void setGalaxy(Integer galaxy) {
		this.galaxy = galaxy;
	}

	public void setSystem(Integer system) {
		this.system = system;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.galaxy + ":" + this.getSystem();
	}
}
