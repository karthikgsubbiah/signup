package com.karthik.signupApp.controller.user;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.signupApp.exception.UserNotFoundException;
import com.karthik.signupApp.model.AppUser;
import com.karthik.signupApp.model.PasswordChangeRequest;
import com.karthik.signupApp.service.AppUserService;

import lombok.AllArgsConstructor;

/**
 * 
 * @author karthikgsubbiah
 * 
 *         Service for managing App user profile
 *
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/profile")
public class ProfileController {

	@Inject
	private AppUserService appUserService;

	@GetMapping("/getUserProfile")
	public AppUser getUserProfileByEmail(@RequestParam String email) throws UserNotFoundException {
		return appUserService.getUserByEmail(email);
	}

	@PostMapping("/updatePassword")
	public boolean updatePassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
		return appUserService.updatePassword(passwordChangeRequest.getEmail(), passwordChangeRequest.getNewPassword(),
				passwordChangeRequest.getConfirmPassword());
	}

	@PostMapping("/confirmPassword")
	public boolean confirmPassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
		return appUserService.confirmPassword(passwordChangeRequest.getEmail(), passwordChangeRequest.getOldPassword());
	}

}
