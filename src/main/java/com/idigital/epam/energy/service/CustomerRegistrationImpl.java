package com.idigital.epam.energy.service;
import static com.idigital.epam.energy.exception.AppConstants.Email_Exist;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.dao.CustomerDao;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;
import com.idigital.epam.energy.exception.EmailAlreadyExistException;

@Service
@Transactional
public class CustomerRegistrationImpl implements CustomerRegistration {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Integer addCustomer(Customer customer) throws CustomerException {
		try {
			Customer existingCustomer=customerDao.findByEmailId(customer.getEmail());
			if(existingCustomer==null) {
				customerDao.save(customer);
				return 1;
			}else {
				throw new EmailAlreadyExistException(Email_Exist);
			}
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}

	}

	@Override
	public Customer findEmail(String email) throws CustomerException {
		try {
			Customer customer=customerDao.findByEmailId(email);
			customer.setIsEnabled(true);
			customerDao.save(customer);
			return customer;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}
	

}
