package com.karthik.signupApp.controller.registration;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.signupApp.model.RegistrationRequest;
import com.karthik.signupApp.service.registration.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/registration")
public class RegistrationController {

	@Inject
	private RegistrationService registrationService;

	@PostMapping
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.registerUser(request);
	}

}
