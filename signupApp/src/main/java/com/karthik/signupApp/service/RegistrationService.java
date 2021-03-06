package com.karthik.signupApp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.karthik.signupApp.model.AppUser;
import com.karthik.signupApp.model.RegistrationRequest;

@Service
public class RegistrationService {

	@Inject
	private AppUserService appUserService;

	public String registerUser(RegistrationRequest request) {
		AppUser appUser = new AppUser(request);
		return appUserService.signUpUser(appUser);
	}

}
