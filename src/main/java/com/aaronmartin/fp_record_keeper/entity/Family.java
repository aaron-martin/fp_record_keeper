package com.aaronmartin.fp_record_keeper.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Integer mainContact;
	private Integer mainLocation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMainContact() {
		return mainContact;
	}

	public void setMainContact(Integer mainContact) {
		this.mainContact = mainContact;
	}

	public Integer getMainLocation() {
		return mainLocation;
	}

	public void setMainLocation(Integer mainLocation) {
		this.mainLocation = mainLocation;
	}

}
