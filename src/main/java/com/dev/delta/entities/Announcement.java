package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Announcement {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String Title;
	@ManyToOne
	@JoinColumn(name="location_id")
	Location Location;
	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement Department;
	String StartDate;
	String EndDate;
	String Attachment;
	String Summary;
	String Description;
	
	public Announcement() {
		// TODO Auto-generated constructor stub
	}

	public Announcement(String title, com.dev.delta.entities.Location location, Departement department,
			String startDate, String endDate, String attachment, String summary, String description) {
		super();
		Title = title;
		Location = location;
		Department = department;
		StartDate = startDate;
		EndDate = endDate;
		Attachment = attachment;
		Summary = summary;
		Description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
	}

	public Departement getDepartment() {
		return Department;
	}

	public void setDepartment(Departement department) {
		Department = department;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getAttachment() {
		return Attachment;
	}

	public void setAttachment(String attachment) {
		Attachment = attachment;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	

}
