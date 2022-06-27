package com.karthik.signupApp.model;

import java.util.UUID;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    public User(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    
    public String getUserId() {
        return userId;
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

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
}
