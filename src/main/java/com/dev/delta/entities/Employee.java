package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String fullName;
	String phone;
	String birthDay;
	String gender;
	String presentAddress;
	String permanentAddress;
	String photo;
	String note;
	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement departement;
	@ManyToOne
	@JoinColumn(name="job_id")
	Job job;
	String joiningDate;
	@ManyToOne
	@JoinColumn(name="salary_id")
	Salary salary;
	String emergencyContactNumber;
	String contactNumber;
	String contactNote;
	String resume;
	String offerLetter;
	String joiningLetter;
	String contractAgreement;
	String identityProof;
	@ManyToOne
	@JoinColumn(name="contract_type_id")
	ContractType contractType;
	String maritalStatus;
	String numberOfChildren;
	String coach;
	String manager;
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String fullName, String phone, String birthDay, String gender, String presentAddress,
			String permanentAddress, String photo, String note, Departement departement, Job job,
			String joiningDate, Salary salary, String emergencyContactName, String contactNumber,
			String emergencyContactNumber, String contactNote, String resume, String offerLetter, String joiningLetter,
			String contractAgreement, String identityProof, ContractType contractType) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.birthDay = birthDay;
		this.gender = gender;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.photo = photo;
		this.note = note;
		this.departement = departement;
		
		this.job = job;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.emergencyContactNumber = emergencyContactName;
		this.contactNumber = contactNumber;
		this.emergencyContactNumber = emergencyContactNumber;
		this.contactNote = contactNote;
		this.resume = resume;
		this.offerLetter = offerLetter;
		this.joiningLetter = joiningLetter;
		this.contractAgreement = contractAgreement;
		this.identityProof = identityProof;
		this.contractType = contractType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	

	public String getContactNote() {
		return contactNote;
	}

	public void setContactNote(String contactNote) {
		this.contactNote = contactNote;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getOfferLetter() {
		return offerLetter;
	}

	public void setOfferLetter(String offerLetter) {
		this.offerLetter = offerLetter;
	}

	public String getJoiningLetter() {
		return joiningLetter;
	}

	public void setJoiningLetter(String joiningLetter) {
		this.joiningLetter = joiningLetter;
	}

	public String getContractAgreement() {
		return contractAgreement;
	}

	public void setContractAgreement(String contractAgreement) {
		this.contractAgreement = contractAgreement;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
}
