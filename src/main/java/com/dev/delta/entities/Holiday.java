package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String HolidayReason;
	String HolidayDate;
	String HolidayDescription;
	
	public Holiday() {
		// TODO Auto-generated constructor stub
	}

	public Holiday(String holidayReason, String holidayDate, String holidayDescription) {
		super();
		HolidayReason = holidayReason;
		HolidayDate = holidayDate;
		HolidayDescription = holidayDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHolidayReason() {
		return HolidayReason;
	}

	public void setHolidayReason(String holidayReason) {
		HolidayReason = holidayReason;
	}

	public String getHolidayDate() {
		return HolidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		HolidayDate = holidayDate;
	}

	public String getHolidayDescription() {
		return HolidayDescription;
	}

	public void setHolidayDescription(String holidayDescription) {
		HolidayDescription = holidayDescription;
	}
	
	
}
