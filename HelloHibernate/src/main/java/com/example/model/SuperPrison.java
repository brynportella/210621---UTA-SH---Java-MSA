package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="super_prison")
public class SuperPrison {
	
	@Id
	@Column(name="prison_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prisonId;
	
	@Column(name="prison_name")
	private String prisonName;
	
	@Column(name="prison_location")
	private String prisonLocation;
	
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY)
	private List<SuperVillain> villList = new ArrayList<SuperVillain>();
	
	public SuperPrison() {
		
	}
	
	public SuperPrison(String prisonName, String prisonLocation, List<SuperVillain> villList) {
		this.prisonName = prisonName;
		this.prisonLocation = prisonLocation;
		this.villList = villList;
	}

	public SuperPrison(int prisonId, String prisonName, String prisonLocation, List<SuperVillain> villList) {
		super();
		this.prisonId = prisonId;
		this.prisonName = prisonName;
		this.prisonLocation = prisonLocation;
		this.villList = villList;
	}
	
	public SuperPrison(String prisonName, String prisonLocation) {
		this.prisonName = prisonName;
		this.prisonLocation = prisonLocation;
	}

	public int getPrisonId() {
		return prisonId;
	}

	public void setPrisonId(int prisonId) {
		this.prisonId = prisonId;
	}

	public String getPrisonName() {
		return prisonName;
	}

	public void setPrisonName(String prisonName) {
		this.prisonName = prisonName;
	}

	public String getPrisonLocation() {
		return prisonLocation;
	}

	public void setPrisonLocation(String prisonLocation) {
		this.prisonLocation = prisonLocation;
	}

	public List<SuperVillain> getVillList() {
		return villList;
	}

	public void setVillList(List<SuperVillain> villList) {
		this.villList = villList;
	}

	@Override
	public String toString() {
		return "SuperPrison [prisonId=" + prisonId + ", prisonName=" + prisonName + ", prisonLocation=" + prisonLocation
				+ ", villList=" + villList + "]";
	}
	
}
