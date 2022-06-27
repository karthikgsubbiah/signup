package com.karthik.signupApp.user;

import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.karthik.signupApp.controller.user.ProfileController;
import com.karthik.signupApp.exception.UserNotFoundException;
import com.karthik.signupApp.model.AppUser;
import com.karthik.signupApp.model.PasswordChangeRequest;
import com.karthik.signupApp.service.AppUserService;

/**
 * 
 * @author karthikgsubbiah
 * 
 *         Test class for {@link ProfileController}
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

	@Mock
	private AppUserService appUserService;

	@InjectMocks
	private ProfileController profileController;

	@Test
	public void testGetUserProfileByEmail() throws UserNotFoundException {
		Mockito.when(appUserService.getUserByEmail("subbiah@gmail.com")).thenReturn(getAppUser());
		AppUser appUser = profileController.getUserProfileByEmail("subbiah@gmail.com");
		Mockito.verify(appUserService, times(1)).getUserByEmail("subbiah@gmail.com");
		Assert.assertEquals("subbiah@gmail.com", appUser.getEmailAddress());
		Assert.assertEquals("Karthik", appUser.getFirstName());
		Assert.assertEquals("Subbiah", appUser.getLastName());
	}

	@Test
	public void testUpdatePassword() throws UserNotFoundException {
		Mockito.when(appUserService.updatePassword("subbiah@gmail.com", "pass1", "pass1")).thenReturn(true);
		boolean result = profileController.updatePassword(getPasswordChangeRequest());
		Assert.assertTrue(result);
	}

	@Test
	public void testConfirmPassword() throws UserNotFoundException {
		Mockito.when(appUserService.updatePassword("subbiah@gmail.com", "pass1", "pass1")).thenReturn(true);
		boolean result = profileController.updatePassword(getPasswordChangeRequest());
		Assert.assertTrue(result);
	}

	private PasswordChangeRequest getPasswordChangeRequest() {
		PasswordChangeRequest passwordChangeRequest = new PasswordChangeRequest();
		passwordChangeRequest.setEmail("subbiah@gmail.com");
		passwordChangeRequest.setNewPassword("pass1");
		passwordChangeRequest.setConfirmPassword("pass1");
		passwordChangeRequest.setOldPassword("pass");
		return passwordChangeRequest;
	}

	private AppUser getAppUser() {
		AppUser appUser = new AppUser("Karthik", "Subbiah", "subbiah@gmail.com", "password", "9876543210");
		return appUser;
	}

}