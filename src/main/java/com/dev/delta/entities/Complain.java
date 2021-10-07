package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Complain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ComplainBy;
	String ComplainAgainst;
	String ComplainTitle;
	String ComplainDate;
	String Description;
	
	public Complain() {
		// TODO Auto-generated constructor stub
	}

	public Complain(String complainBy, String complainAgainst, String complainTitle, String complainDate,
			String description) {
		super();
		ComplainBy = complainBy;
		ComplainAgainst = complainAgainst;
		ComplainTitle = complainTitle;
		ComplainDate = complainDate;
		Description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComplainBy() {
		return ComplainBy;
	}

	public void setComplainBy(String complainBy) {
		ComplainBy = complainBy;
	}

	public String getComplainAgainst() {
		return ComplainAgainst;
	}

	public void setComplainAgainst(String complainAgainst) {
		ComplainAgainst = complainAgainst;
	}

	public String getComplainTitle() {
		return ComplainTitle;
	}

	public void setComplainTitle(String complainTitle) {
		ComplainTitle = complainTitle;
	}

	public String getComplainDate() {
		return ComplainDate;
	}

	public void setComplainDate(String complainDate) {
		ComplainDate = complainDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
