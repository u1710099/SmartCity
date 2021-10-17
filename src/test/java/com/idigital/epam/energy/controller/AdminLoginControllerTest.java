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

import com.idigital.epam.energy.entity.AdminLogin;
import com.idigital.epam.energy.service.AdminLoginServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)

class AdminLoginControllerTest {
	@Mock
	private AdminLoginServiceImpl adminloginService;

	@InjectMocks
	private AdminLoginController adminloginController;

	private final String adminEmail="virat@gmail.com";
	private final String adminPassword="virat@123";


	@Test
	void testAdminSignIn() {

		AdminLogin admin = new AdminLogin();

		admin.setAdminEmail(adminEmail);

		admin.setAdminPassword(adminPassword);

		Mockito.when(adminloginService.adminSignIn(admin)).thenReturn("true");

		//Execute Post request
		ResponseEntity <?> adminlogin =adminloginController.adminSignIn(admin);
		assertEquals(adminlogin.getStatusCodeValue(), 200);

	}

}
