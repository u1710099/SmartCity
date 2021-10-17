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

import com.idigital.epam.energy.entity.CustomerForgot;
import com.idigital.epam.energy.service.CustomerForgotServiceImpl;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class CustomerForgotControllerTest {

	@Mock
	private CustomerForgotServiceImpl customerForgotService;

	@InjectMocks
	private CustomerForgotController customerForgotController;

	private final String email="abcdej@gmail.com";
	private final String newPassword="abc$12345";

	@Test
	void test() {
		CustomerForgot customer=new CustomerForgot();

		customer.setEmail(email);

		Mockito.when(customerForgotService.forgotPassword(customer, newPassword)).thenReturn("true");

		//Execute Post request
		ResponseEntity <?> password =customerForgotController.forgotPassword(customer, newPassword);
		assertEquals(password.getStatusCodeValue(), 200);

	}


}
