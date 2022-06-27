package com.karthik.signupApp.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.karthik.signupApp.dao.AppUserRepository;
import com.karthik.signupApp.exception.UserNotFoundException;
import com.karthik.signupApp.model.AppUser;

import lombok.AllArgsConstructor;

/**
 * 
 * @author karthikgsubbiah
 * 
 *         Service to maintain
 *
 */
@Service
@AllArgsConstructor
public class AppUserService {

	@Inject
	private AppUserRepository appUserRepository;

	@Inject
	private ValidationService validationService;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostConstruct
	public void init() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}

	public AppUser getUserByEmail(String email) throws UserNotFoundException {
		AppUser user = appUserRepository.findByEmail(email);
		return user;
	}

	public String signUpUser(AppUser appUser) {
		if (appUserRepository.findByEmail(appUser.getEmailAddress()) != null) {
			throw new IllegalStateException("Email already taken");
		}

		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		appUserRepository.save(appUser);

		return appUser.getId();
	}

	public int enableAppUser(String email) {
		return appUserRepository.enableAppUser(email);
	}

	public int disableAppUser(String email) {
		return appUserRepository.disableAppUser(email);
	}

	public boolean confirmPassword(String email, String oldPassword) {
		AppUser user = appUserRepository.findByEmail(email);

		if (user == null) {
			throw new IllegalStateException("Email not registered");
		}

		if (oldPassword != null) {
			throw new IllegalArgumentException("Passwords entered is invalid!!!");
		}

		return bCryptPasswordEncoder.encode(oldPassword).equals(user.getPassword());
	}

	public boolean updatePassword(String email, String newPassword, String confirmPassword) {
		if (appUserRepository.findByEmail(email) == null) {
			throw new IllegalStateException("Email not registered");
		}

		if (!validationService.checkForNonNullPasswords(newPassword)
				|| !validationService.checkForNonNullPasswords(confirmPassword)) {
			throw new IllegalArgumentException("Passwords entered are invalid!!!");
		}

		if (!validationService.validateConfirmPassword(newPassword, confirmPassword)) {
			throw new IllegalArgumentException("Passwords entered are not the same");
		}

		String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
		appUserRepository.updatePassword(email, encodedPassword);
		return true;
	}

}
