package com.cooper.aliens.solarsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="solarsystem")
public class SolarSystem {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id = 0;
	
	@Column(name="system_name")
	private String systemName;
	
	@Column(name="xCoordinate")
	private int xCoordinate;
	
	@Column(name="yCoordinate")
	private int yCoordinate;
	
	@Column(name="zCoordinate")
	private int zCoordinate;
	
	
	public SolarSystem() {
		super();
	}


	public SolarSystem(String systemName, int xCoordinate, int yCoordinate, int zCoordinate) {
		super();
		this.systemName = systemName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSystemName() {
		return systemName;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public int getxCoordinate() {
		return xCoordinate;
	}


	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}


	public int getyCoordinate() {
		return yCoordinate;
	}


	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}


	public int getzCoordinate() {
		return zCoordinate;
	}


	public void setzCoordinate(int zCoordinate) {
		this.zCoordinate = zCoordinate;
	}


	@Override
	public String toString() {
		return "SolarSystem [id=" + id + ", systemName=" + systemName + ", xCoordinate=" + xCoordinate
				+ ", yCoordinate=" + yCoordinate + ", zCoordinate=" + zCoordinate + "]";
	}
	
	
	
}
