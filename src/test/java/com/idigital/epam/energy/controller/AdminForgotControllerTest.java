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

import com.idigital.epam.energy.entity.AdminForgot;
import com.idigital.epam.energy.service.AdminForgotServiceImpl;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class AdminForgotControllerTest {

	@Mock
	private AdminForgotServiceImpl adminForgotService;

	@InjectMocks
	private AdminForgotController adminForgotController;

	private final String email="xyz@gmail.com";
	private final String newPassword="efg@432";

	@Test
	void test() {
		AdminForgot admin=new AdminForgot();

		admin.setAdminEmail(email);

		Mockito.when(adminForgotService.forgotPassword(admin, newPassword)).thenReturn("true");

		//Execute Post request
		ResponseEntity <?> password = adminForgotController.forgotPassword(admin, newPassword);
		assertEquals(password.getStatusCodeValue(), 200);

	}



}
