package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="position_id")
	Position position ;
	String Description ;
	String PostedDate;
	String CloseDate;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(Position position, String description, String postedDate, String closeDate) {
		super();
		this.position = position;
		Description = description;
		PostedDate = postedDate;
		CloseDate = closeDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPostedDate() {
		return PostedDate;
	}

	public void setPostedDate(String postedDate) {
		PostedDate = postedDate;
	}

	public String getCloseDate() {
		return CloseDate;
	}

	public void setCloseDate(String closeDate) {
		CloseDate = closeDate;
	}
	
	
}
