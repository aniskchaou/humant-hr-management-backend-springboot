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
	String FullName;
	String Phone;
	String BirthDay;
	String Gender;
	String PresentAddress;
	String PermanentAddress;
	String Photo;
	String Note;
	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement departement;
	@ManyToOne
	@JoinColumn(name="job_id")
	Job job;
	String JoiningDate;
	@ManyToOne
	@JoinColumn(name="salary_id")
	Salary salary;
	String EmergencyContactName;
	String ContactNumber;
	String EmergencyContactNumber;
	String ContactNote;
	String Resume;
	String OfferLetter;
	String JoiningLetter;
	String ContractAgreement;
	String IdentityProof;
	@ManyToOne
	@JoinColumn(name="contract_type_id")
	ContractType contractType;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String fullName, String phone, String birthDay, String gender, String presentAddress,
			String permanentAddress, String photo, String note, Departement departement, Job job,
			String joiningDate, Salary salary, String emergencyContactName, String contactNumber,
			String emergencyContactNumber, String contactNote, String resume, String offerLetter, String joiningLetter,
			String contractAgreement, String identityProof, ContractType contractType) {
		super();
		FullName = fullName;
		Phone = phone;
		BirthDay = birthDay;
		Gender = gender;
		PresentAddress = presentAddress;
		PermanentAddress = permanentAddress;
		Photo = photo;
		Note = note;
		this.departement = departement;
		
		this.job = job;
		JoiningDate = joiningDate;
		this.salary = salary;
		EmergencyContactName = emergencyContactName;
		ContactNumber = contactNumber;
		EmergencyContactNumber = emergencyContactNumber;
		ContactNote = contactNote;
		Resume = resume;
		OfferLetter = offerLetter;
		JoiningLetter = joiningLetter;
		ContractAgreement = contractAgreement;
		IdentityProof = identityProof;
		this.contractType = contractType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPresentAddress() {
		return PresentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		PresentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return PermanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
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
		return JoiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		JoiningDate = joiningDate;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public String getEmergencyContactName() {
		return EmergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		EmergencyContactName = emergencyContactName;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getEmergencyContactNumber() {
		return EmergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		EmergencyContactNumber = emergencyContactNumber;
	}

	public String getContactNote() {
		return ContactNote;
	}

	public void setContactNote(String contactNote) {
		ContactNote = contactNote;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

	public String getOfferLetter() {
		return OfferLetter;
	}

	public void setOfferLetter(String offerLetter) {
		OfferLetter = offerLetter;
	}

	public String getJoiningLetter() {
		return JoiningLetter;
	}

	public void setJoiningLetter(String joiningLetter) {
		JoiningLetter = joiningLetter;
	}

	public String getContractAgreement() {
		return ContractAgreement;
	}

	public void setContractAgreement(String contractAgreement) {
		ContractAgreement = contractAgreement;
	}

	public String getIdentityProof() {
		return IdentityProof;
	}

	public void setIdentityProof(String identityProof) {
		IdentityProof = identityProof;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	
	
}
