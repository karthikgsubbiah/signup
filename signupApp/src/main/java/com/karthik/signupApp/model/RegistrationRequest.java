package com.karthik.signupApp.model;

/**
 * 
 * @author karthikgsubbiah
 * 
 *         Model class for constructing registration request
 *
 */
public class RegistrationRequest {

	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
	private final String phoneNumber;
	private final boolean isAdmin;

	public RegistrationRequest(String firstName, String lastName, String email, String password, String phoneNumber,
			boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

}
