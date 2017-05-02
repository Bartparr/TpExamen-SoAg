package com.soag.beans;

import java.util.Date;
/*
 * Cette bean correspond aux différentes personnes utilisant notre projet de société agricole, client ou conseiller
 */
public class Person {
	private int id;
	private int externalId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String token;
	private String phoneNumber;
	private Date createdAt;
	private Date updatedAt;
	private int advisorId;
	private int isAdvisor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExternalId() {
		return externalId;
	}
	public void setExternalId(int externalId) {
		this.externalId = externalId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getAdvisorId() {
		return advisorId;
	}
	public void setAdvisorId(int advisorId) {
		this.advisorId = advisorId;
	}
	public int getIsAdvisor() {
		return isAdvisor;
	}
	public void setIsAdvisor(int isAdvisor) {
		this.isAdvisor = isAdvisor;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
