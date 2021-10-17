package com.idigital.epam.energy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.idigital.epam.energy.dao.ConfirmationTokenDao;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.service.CustomerRegistrationImpl;
import com.idigital.epam.energy.service.CustomerServiceImpl;
import com.idigital.epam.energy.service.EmailSenderService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
	@Mock
	private ConfirmationTokenDao tokenDao;
	@Mock
	private EmailSenderService emailService;
	@Mock
	private CustomerServiceImpl customerService;
	@Mock
	private CustomerRegistrationImpl customerRegistrationImpl;

	@InjectMocks
	private CustomerRegistrationController customerRegistrationController;
	@InjectMocks
	private CustomerController customerController;

	private final Integer custId=1;
	private final String firstName="Virat";
	private final String LastName="Kohli";
	private final String email="virat@gmail.com";
	private final String mobile="9852123265";
	private final String password="virat@123";
	private final String address="AK Road,Nagpur";
	private final String state="xxx";
	private final String city="yyy";
	private final String pin="11111";


	@Test
	void testAddCustomer() throws Exception {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		Mockito.when(customerRegistrationImpl.addCustomer(customer)).thenReturn(1);

		//Execute Post request
		String respose=customerRegistrationController.addCustomer(customer);
		assertEquals(respose, "Registration successfull check email for confirmation");

	}	

	@Test
	void testGetCustomerById() throws Exception {
		Customer customer=new Customer();
		customer.setId(custId);
		Mockito.when(customerService.getCustomerById(custId)).thenReturn(customer);
		// Execute the GET request
		ResponseEntity<Customer> id=customerController.getCustomerById(custId);

		//validate response
		assertEquals(id.getStatusCodeValue(), 200);



	}

	@Test
	void testGetAllCustomer() throws Exception {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		List<Customer> custList=new ArrayList<Customer>();
		custList.add(customer);
		Mockito.when(customerService.getAllCustomer()).thenReturn(custList);
		// Execute the GET request
		ResponseEntity<List<Customer>> list=customerController.getAllCustomer();

		// Validate the response code 
		assertEquals(list.getStatusCodeValue(), 200);
	}

	@Test
	void testDeleteCustomer() throws Exception {
		Mockito.when(customerService.deleteCustomer(custId)).thenReturn(1);

		//Execute Delete request
		String deleted=customerController.deleteCustomer(custId);

		//validate response
		assertEquals(deleted, "customer: "+custId+" deleted from database");
	}

	@Test
	void testUpdateCustomerProfile() throws Exception {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName("Rohit");
		Mockito.when(customerService.updateCustomerProfile(customer)).thenReturn(customer);

		//Execute Update request
		ResponseEntity<Customer> updated=customerController.updateCustomerProfile(customer);
		assertEquals(updated.getStatusCodeValue(),200 );

	}

	@Test
	void testAddMoreDetails() throws Exception {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setPincode(pin);
		Mockito.when(customerService.addMoreDetails(customer, custId)).thenReturn(customer);

		//Execute Update request
		ResponseEntity<Customer> add=customerController.addMoreDetails(customer, custId);
		assertEquals(add.getStatusCodeValue(),200 );
	}

	@Test
	void testGetCustIdByEmail() throws Exception {
		Customer customer=new Customer();
		customer.setEmail(email);
		Mockito.when(customerService.getIdByEmail(email)).thenReturn(1);

		//Execute Get request
		Integer id=customerController.getCustIdByEmail(email);
		assertEquals(id, custId);
	}

}
