package com.SpringHMS.Doctordetails.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "Doctor")
public class Doctor {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="emailId")
	private String emailId;
	@Column(name="specialization")
	private String specialization;
	@Column(name="phoneNo",unique=true)
	private Long phoneNo;
	@Column(name="qualification")
	private String qualification;
	public Doctor() {}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		
	}
		public Long getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(Long phoneNo) {
			this.phoneNo=phoneNo;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification=qualification;
		}
		public Doctor(Long id, String firstName, String lastName, String emailId, String specialization) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
			this.specialization = specialization;
	}
		
	
}

