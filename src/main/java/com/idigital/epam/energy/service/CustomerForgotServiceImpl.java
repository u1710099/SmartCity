package com.idigital.epam.energy.service;

import java.util.Optional;

import com.idigital.epam.energy.dao.CustomerForgotDao;
import com.idigital.epam.energy.entity.CustomerForgot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.OperationFailedException;
import com.idigital.epam.energy.exception.ResourceNotFound;
//import com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
//import com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;

import static com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
import static com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;

@Service
public class CustomerForgotServiceImpl implements CustomerForgotService {


	@Autowired
	private CustomerForgotDao customerForgotdao;

	@Override
	public String forgotPassword(CustomerForgot customer, String newPassword) {
		String str = null;
		Optional<Customer> userObj = customerForgotdao.findByEmailId(customer.getEmail());

		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		}
		try {
			userObj.get().setPassword(newPassword);
			customerForgotdao.saveAndFlush(userObj.get());
			str = "Password updated sucessfully";
		} catch (Exception e) {
			throw new OperationFailedException(OPERATION_FAILED);
		}
		return str;
	}

}
