package com.idigital.epam.energy.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.idigital.epam.energy.entity.Login;
import com.idigital.epam.energy.service.LoginServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class LoginControllerTest {
	@Mock
	private LoginServiceImpl loginService;

	@InjectMocks
	private LoginController loginController;

	private final String email="virat@gmail.com";
	private final String password="virat@123";



	@Test
	void testSignIn() {
		Login customer=new Login();

		customer.setEmail(email);

		customer.setPassword(password);

		Mockito.when(loginService.signIn(customer)).thenReturn("true");

		//Execute Post request
		ResponseEntity <?> login =loginController.signIn(customer);
		assertEquals(login.getStatusCodeValue(), 200);

	}

}
