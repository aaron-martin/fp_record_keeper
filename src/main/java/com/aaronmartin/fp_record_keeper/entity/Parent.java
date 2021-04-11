package com.aaronmartin.fp_record_keeper.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String description;
	private Integer family;
	private Integer mainContact;
	private Integer mainLocation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFamily() {
		return family;
	}

	public void setFamily(Integer family) {
		this.family = family;
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
