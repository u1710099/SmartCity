package com.idigital.epam.energy.controller;

import java.util.List;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;
import com.idigital.epam.energy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Get customer by Id",response = Customer.class,
			tags="get-customer-by-id",consumes="custId",httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
		try {
			Customer customer=customerService.getCustomerById(id);
			if(customer!=null) {
				return new ResponseEntity<>(customer,HttpStatus.OK);
			}
			else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}catch(CustomerException customerException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}

	}

	@ApiOperation(value = "Get all customer",response = Customer.class,
			tags="get-all-customer",httpMethod = "GET")
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		try {
			List<Customer> custList=customerService.getAllCustomer();
			return new ResponseEntity<>(custList,HttpStatus.OK);
		}catch(CustomerException customerException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}

	@ApiOperation(value = "Delete Customer",consumes = "custId",
			response =String.class)
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		try {
			Integer status=customerService.deleteCustomer(id);
			if(status==1) {
				return "customer: "+id+" deleted from database";
			}
			else {
				return "Unable to delete customer from database";
			}
		}catch(CustomerException customerException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}

	@ApiOperation(value = "Update Customer",
			consumes = "receives Customer object as request body",
			response =Customer.class)
	@PutMapping("/")
	public ResponseEntity<Customer> updateCustomerProfile(@RequestBody Customer customer){
		try {
			Customer updatedCustomer=customerService.updateCustomerProfile(customer);
			return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		}catch(CustomerException customerException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}
	@ApiOperation(value = "Add More Information Of Customer",
			consumes = "receives Customer object as request body",
			response =Customer.class)
	@PutMapping("/addMore/{id}")
	public ResponseEntity<Customer> addMoreDetails(@RequestBody Customer customer,@PathVariable Integer id){
		try {

			Customer addMore=customerService.addMoreDetails(customer,id);
			return new ResponseEntity<>(addMore,HttpStatus.OK);
		}catch(CustomerException customerException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}

	@ApiOperation(value = "Get customer id by email",response = Customer.class,
			tags="get-customer-id-by-email",consumes="email",httpMethod = "GET")
	@GetMapping("/email/{email}")
	public Integer getCustIdByEmail(@PathVariable String email) {
		try {
			Integer id=customerService.getIdByEmail(email);
			if(id!=null) {
				return id;
			}else
			{
				return 0;
			}
		}catch(CustomerException customerException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}

}
