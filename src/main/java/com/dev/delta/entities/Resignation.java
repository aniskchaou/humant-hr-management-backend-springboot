package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Resignation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee EmployeeName;
	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement departement;
	@ManyToOne
	@JoinColumn(name="notice_id")
	Notice NoticeDate;
	String ResignationDate;
	String ResignationReason;
	
	public Resignation() {
		// TODO Auto-generated constructor stub
	}

	public Resignation(Employee employeeName, Departement departement, Notice noticeDate, String resignationDate,
			String resignationReason) {
		super();
		EmployeeName = employeeName;
		this.departement = departement;
		NoticeDate = noticeDate;
		ResignationDate = resignationDate;
		ResignationReason = resignationReason;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(Employee employeeName) {
		EmployeeName = employeeName;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Notice getNoticeDate() {
		return NoticeDate;
	}

	public void setNoticeDate(Notice noticeDate) {
		NoticeDate = noticeDate;
	}

	public String getResignationDate() {
		return ResignationDate;
	}

	public void setResignationDate(String resignationDate) {
		ResignationDate = resignationDate;
	}

	public String getResignationReason() {
		return ResignationReason;
	}

	public void setResignationReason(String resignationReason) {
		ResignationReason = resignationReason;
	}
	
	
}
