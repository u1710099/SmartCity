package com.idigital.epam.energy.service;

import java.util.List;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;

public interface CustomerService {
	public Customer getCustomerById(Integer id) throws CustomerException;
	public Integer deleteCustomer(Integer id) throws CustomerException;
	public List<Customer> getAllCustomer() throws CustomerException;
	public Customer updateCustomerProfile(Customer customer) throws CustomerException;
	public Integer getIdByEmail(String email) throws CustomerException;
	public Customer addMoreDetails(Customer customer,Integer id) throws CustomerException;
}
