package com.karthik.signupApp.service;

import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.karthik.signupApp.dao.AppUserRepository;
import com.karthik.signupApp.exception.UserNotFoundException;
import com.karthik.signupApp.model.AppUser;

/**
 * 
 * @author karthikgsubbiah
 *
 *         Test class for {@link AppUserService}
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppUserServiceTest {

	@Mock
	private AppUserRepository appUserRepository;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@InjectMocks
	private AppUserService appUserService;

	@Test
	public void testetUserByEmail() throws UserNotFoundException {
		Mockito.when(appUserRepository.findByEmail("subbiah@gmail.com")).thenReturn(getAppUser());
		AppUser appUser = appUserService.getUserByEmail("subbiah@gmail.com");
		Mockito.verify(appUserRepository, times(1)).findByEmail("subbiah@gmail.com");
		Assert.assertEquals("subbiah@gmail.com", appUser.getEmailAddress());
		Assert.assertEquals("Karthik", appUser.getFirstName());
		Assert.assertEquals("Subbiah", appUser.getLastName());
	}

	@Test
	public void testSignUpUser() {
		AppUser user = getAppUser();
		Mockito.when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("passss");
		String userId = appUserService.signUpUser(user);
		Mockito.verify(appUserRepository, times(1)).save(user);
		Assert.assertNotNull(userId);
	}

	private AppUser getAppUser() {
		AppUser appUser = new AppUser("Karthik", "Subbiah", "subbiah@gmail.com", "password", "9876543210");
		return appUser;
	}

}
