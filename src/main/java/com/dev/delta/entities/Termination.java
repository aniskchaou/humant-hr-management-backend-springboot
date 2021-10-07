package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Termination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="type_termination_id")
	TypeTermination typeTermination;
	String Reason;
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee Name;
	String NoticeDate;
	String TerminationDate;
	String Description;
	
	public Termination() {
		// TODO Auto-generated constructor stub
	}

	public Termination(TypeTermination typeTermination, String reason, Employee name, String noticeDate,
			String terminationDate, String description) {
		super();
		this.typeTermination = typeTermination;
		Reason = reason;
		Name = name;
		NoticeDate = noticeDate;
		TerminationDate = terminationDate;
		Description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeTermination getTypeTermination() {
		return typeTermination;
	}

	public void setTypeTermination(TypeTermination typeTermination) {
		this.typeTermination = typeTermination;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public Employee getName() {
		return Name;
	}

	public void setName(Employee name) {
		Name = name;
	}

	public String getNoticeDate() {
		return NoticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		NoticeDate = noticeDate;
	}

	public String getTerminationDate() {
		return TerminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		TerminationDate = terminationDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
