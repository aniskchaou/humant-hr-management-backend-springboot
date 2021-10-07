package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="type_training_id")
	TypeTraining typetraining;
	@ManyToOne
	@JoinColumn(name="trainer_id")
	Trainer Name;
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee Employee;
	String StartDate;
	String EndDate;
	String Description;
	public Training() {
		// TODO Auto-generated constructor stub
	}
	public Training(TypeTraining typetraining, Trainer name, com.dev.delta.entities.Employee employee, String startDate,
			String endDate, String description) {
		super();
		this.typetraining = typetraining;
		Name = name;
		Employee = employee;
		StartDate = startDate;
		EndDate = endDate;
		Description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeTraining getTypetraining() {
		return typetraining;
	}
	public void setTypetraining(TypeTraining typetraining) {
		this.typetraining = typetraining;
	}
	public Trainer getName() {
		return Name;
	}
	public void setName(Trainer name) {
		Name = name;
	}
	public Employee getEmployee() {
		return Employee;
	}
	public void setEmployee(Employee employee) {
		Employee = employee;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
