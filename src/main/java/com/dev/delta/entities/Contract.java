package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee employee; 
	String Subject;
	String ContractValue;
	@ManyToOne
	@JoinColumn(name="contract_type_id")
	ContractType ContractType;
	String StartDate;
	String EndDate;
	String Description;
	
	public Contract() {
		// TODO Auto-generated constructor stub
	}

	public Contract(Employee employee, String subject, String contractValue,
			com.dev.delta.entities.ContractType contractType, String startDate, String endDate, String description) {
		super();
		this.employee = employee;
		Subject = subject;
		ContractValue = contractValue;
		ContractType = contractType;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getContractValue() {
		return ContractValue;
	}

	public void setContractValue(String contractValue) {
		ContractValue = contractValue;
	}

	public ContractType getContractType() {
		return ContractType;
	}

	public void setContractType(ContractType contractType) {
		ContractType = contractType;
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
