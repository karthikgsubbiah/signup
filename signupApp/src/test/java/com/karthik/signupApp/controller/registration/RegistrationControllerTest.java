package com.karthik.signupApp.controller.registration;

import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.karthik.signupApp.model.RegistrationRequest;
import com.karthik.signupApp.model.UserRole;
import com.karthik.signupApp.service.registration.RegistrationService;

/**
 * 
 * @author karthikgsubbiah
 *
 *         Test class for {@link RegistrationController}
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@Mock
	private RegistrationService registrationService;

	@InjectMocks
	private RegistrationController registrationController;

	@Test
	public void testRegister() {
		RegistrationRequest registrationRequest = new RegistrationRequest("Karthik", "Subbiah", "subbiah@gmail.com",
				"password", "8807895567", false);
		registrationController.register(registrationRequest);
		Mockito.verify(registrationService, times(1)).registerUser(registrationRequest);
	}
}
