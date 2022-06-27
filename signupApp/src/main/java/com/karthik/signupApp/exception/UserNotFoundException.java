package com.karthik.signupApp.exception;

public class UserNotFoundException extends Exception {
	
	private static String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User not found";
	
	public UserNotFoundException() {
		super(USER_NOT_FOUND_EXCEPTION_MESSAGE);
	}
	
	public UserNotFoundException(final String message) {
		super(message);
	}
	
}
