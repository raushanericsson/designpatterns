package com.lenskart.manifest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	
	private static long serialVersionUID = 1L;

	@javax.persistence.Id 
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer Id;
	
	@Column(name="first_name")
	String FirstName;
	
	@Column(name="last_name")
	String LastName;
	
	@Column(name="country")
	String Country;
	
	@Column(name="company")
	String Company;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
}
