package com.lenskart.manifest.model;

import javax.persistence.Column;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MongoUsers")
public class MongoUsers {
	
	@Id
	public ObjectId _id;
	
	@Column(name="id")
	public String Id;
	
	@Column(name="first_name")
	public String FirstName;
	
	@Column(name="last_name")
	public String LastName;
	
	@Column(name="country")
	public String Country;
	
	@Column(name="company")
	public String Company;
	
	public MongoUsers(Integer id,String first_name,String last_name,String country,String company) {
		this.FirstName = first_name;
		this.LastName = last_name;
		this.Country = country;
		this.Company = company;
	}
	

}