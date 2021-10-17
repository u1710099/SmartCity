package com.idigital.epam.energy.service;;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;

public interface CustomerRegistration {
	public Integer addCustomer(Customer customer) throws CustomerException;
	public Customer findEmail(String email) throws CustomerException;
}
