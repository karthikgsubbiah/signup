package com.karthik.signupApp.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AppUser {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	@JsonIgnore
	private String password;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private UserRole appUserRole;
	private boolean isEnabled;

	public AppUser() {

	}
	
	public AppUser(String firstName, String lastName, String emailAddress, String password, String phoneNumber) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public AppUser(String firstName, String lastName, String emailAddress, String password,
			String phoneNumber, UserRole appUserRole) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.appUserRole = appUserRole;
	}

	public AppUser(RegistrationRequest registrationRequest) {
		this.id = UUID.randomUUID().toString();
		this.firstName = registrationRequest.getFirstName();
		this.lastName = registrationRequest.getLastName();
		this.emailAddress = registrationRequest.getEmail();
		this.password = registrationRequest.getPassword();
		this.phoneNumber = registrationRequest.getPhoneNumber();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return new StringBuilder().append(firstName).append(" ").append(lastName).toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getAppUserRole() {
		return appUserRole;
	}

	public void setAppUserRole(UserRole appUserRole) {
		this.appUserRole = appUserRole;
	}

}
