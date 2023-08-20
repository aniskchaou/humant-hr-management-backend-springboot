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
	String subject;
	String contractValue;
	@ManyToOne
	@JoinColumn(name="contract_type_id")
	ContractType contractType;
	String startDate;
	String endDate;
	String description;
	String status;
	String job;
	String departement;
	String salaryStructureType;
	String workingSchedule;
	
	

	
	
	
	
	
	
	
	
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getSalaryStructureType() {
		return salaryStructureType;
	}

	public void setSalaryStructureType(String salaryStructureType) {
		this.salaryStructureType = salaryStructureType;
	}

	public String getWorkingSchedule() {
		return workingSchedule;
	}

	public void setWorkingSchedule(String workingSchedule) {
		this.workingSchedule = workingSchedule;
	}

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	public Contract(Employee employee, String subject, String contractValue,
			com.dev.delta.entities.ContractType contractType, String startDate, String endDate, String description) {
		super();
		this.employee = employee;
		this.subject = subject;
		this.contractValue = contractValue;
		this.contractType = contractType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
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
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContractValue() {
		return contractValue;
	}

	public void setContractValue(String contractValue) {
		this.contractValue = contractValue;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
