package com.cors.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_orgnization")
public class Orgnization {

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message = "The name must not be empty !")
	@Column(length = 100)
	private String name;

	@Column(length = 100)
	private String address;
	
	@Email(message = "The format of email is incorrect !")
	@Column(length = 100)
	private String email;

	@Column(length = 100)
	private String officePhone;
	
	public Orgnization() {
	}

	public Orgnization(int id, String name, String address, String email, String officePhone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.officePhone = officePhone;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

}
