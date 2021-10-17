package com.idigital.epam.energy.service;

import java.util.List;
import java.util.Optional;

import com.idigital.epam.energy.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;


	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		try {
			Optional<Customer> optional=customerDao.findById(id);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public Integer deleteCustomer(Integer id) throws CustomerException {
		try {
			customerDao.deleteById(id);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		try {
			List<Customer> customerList=customerDao.findAll();
			return customerList;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public Customer updateCustomerProfile(Customer customer) throws CustomerException {
		try {
			customer.setIsEnabled(true);
			Customer update=customerDao.save(customer);
			return update;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}



	@Override
	public Customer addMoreDetails(Customer customer,Integer id) throws CustomerException {
		try {
			Customer cust=customerDao.findById(id).get();
			cust.setAddress(customer.getAddress());
			cust.setCity(customer.getCity());
			cust.setState(customer.getState());
			cust.setPincode(customer.getPincode());
			Customer addMore=customerDao.save(cust);
			return addMore;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public Integer getIdByEmail(String email) throws CustomerException {
		try {
			Optional<Customer> customer=customerDao.getDataByEmail(email);
			if(customer.isPresent()) {
				return customer.get().getId();
			}
			else {
				throw new CustomerException("Id not found");
			}
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

}
