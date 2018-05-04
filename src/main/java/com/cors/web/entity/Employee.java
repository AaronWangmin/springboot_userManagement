package com.cors.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_employee")
public class Employee {

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message = "The name must not be empty!")
	@Column(length = 100)
	private String name;

	@Column(length = 100)
	private String capital;
	
	
	@Email(message = "The format of email is incorrect!")
	@Column(length = 100)
	private String email;

	@Column(length = 100)
	private String mobilePhone;

	@Column(length = 100)
	private String officePhone;
	
	@Column
	private int orgnizationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public int getOrgnizationId() {
		return orgnizationId;
	}

	public void setOrgnizationId(int orgnizationId) {
		this.orgnizationId = orgnizationId;
	}

}
