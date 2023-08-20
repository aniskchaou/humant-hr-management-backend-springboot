package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaySlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
String startDate;
String endDate;
String contract;	
	
String structure;	
 
String workedDays;
String note;

public PaySlip() {
	// TODO Auto-generated constructor stub
}



public PaySlip(String startDate, String endDate, String contract, String structure, String workedDays, String note) {
	super();
	this.startDate = startDate;
	this.endDate = endDate;
	this.contract = contract;
	this.structure = structure;
	this.workedDays = workedDays;
	this.note = note;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
}

public String getContract() {
	return contract;
}

public void setContract(String contract) {
	this.contract = contract;
}

public String getStructure() {
	return structure;
}

public void setStructure(String structure) {
	this.structure = structure;
}

public String getWorkedDays() {
	return workedDays;
}

public void setWorkedDays(String workedDays) {
	this.workedDays = workedDays;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}



}
