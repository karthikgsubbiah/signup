package com.karthik.signupApp.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	
	public boolean validatePhoneNumber(String phoneNumber) {
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher match = ptrn.matcher(phoneNumber);
		return (match.find() && match.group().equals(phoneNumber));
	}
	
	public boolean checkForInvalidPasswords(String password) {
		return password != null && !password.isEmpty();
	}

	public boolean validateConfirmPassword(String newPassword, String confirmPassword) {
		return newPassword.equals(confirmPassword);
	}

}
