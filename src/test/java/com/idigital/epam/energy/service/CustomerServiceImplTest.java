package com.idigital.epam.energy.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.idigital.epam.energy.dao.CustomerDao;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
	@Mock
	private CustomerDao customerDao;
	@InjectMocks
	private CustomerServiceImpl customerService;
	@InjectMocks
	private CustomerRegistrationImpl customerRegistrationImpl;

	private final Integer custId=1;
	private final String firstName="Virat";
	private final String LastName="Kohli";
	private final String email="virat@gmail.com";
	private final String mobile="9852123265";
	private final String password="virat@123";
	private final String address="AK Road,Nagpur";
	private final String state="Maharashtra";
	private final String city="Nagpur";
	private final String pin="440012";

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
	}



	@Test
	void testGetCustomerById() throws CustomerException {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		customerService.getCustomerById(custId);
		verify(customerDao,times(1)).findById(custId);

	}
	
	@Test
	void testAddCustomer() throws CustomerException {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		customerRegistrationImpl.addCustomer(customer);
		verify(customerDao,times(1)).save(customer);
		
		
	}

	@Test
	void testDeleteCustomer() throws CustomerException  {
		Customer customer=new Customer();
		customer.setId(custId);
		customerService.deleteCustomer(custId);
		verify(customerDao,times(1)).deleteById(custId);
	}

	@Test
	void testGetAllCustomer() throws CustomerException {
		Customer customer=new Customer();
		List<Customer> custList=new ArrayList<Customer>();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		Mockito.when(customerDao.findAll()).thenReturn(custList);
		assertEquals(custList, customerService.getAllCustomer());
	}

	@Test
	void testUpdateCustomerProfile() throws CustomerException {
		Customer customer=new Customer();
		customer.setId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(LastName);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setPincode(pin);
		customer.setFirstName("Rohit");
		customerService.updateCustomerProfile(customer);
		assertEquals("Rohit", customer.getFirstName());
	}

}
