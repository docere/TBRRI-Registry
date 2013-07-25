package com.example;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@NamedQueries({
		@NamedQuery(name = Person.FIND_ALL_PERSONS, query = "SELECT a FROM Person a"),

})

@Entity
public class Person {

	public static final String FIND_ALL_PERSONS = "Person.findAllPersons";	
	public Person()
	{
		
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@Basic
	String lastName;
	
	@Basic
	String firstName;
	
	@Basic
	String address1;
	
	@Basic
	String city;
	
	@Basic
	String province;
	
	@Basic
	String postalCode;
	
	@Basic
	String country;
	
	@Basic
	String emailAddress;
	
	@Basic
	String phone;

	
	
	


	
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	
	

}

