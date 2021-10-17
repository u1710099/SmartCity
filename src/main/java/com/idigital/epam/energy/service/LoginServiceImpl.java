package com.idigital.epam.energy.service;

import static com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
import static com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;
import static com.idigital.epam.energy.exception.AppConstants.WRONG_PASSWORD;

import java.util.Optional;

import com.idigital.epam.energy.dao.LoginDao;
import com.idigital.epam.energy.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.OperationFailedException;
import com.idigital.epam.energy.exception.ResourceNotFound;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public String signIn(Login customer) {
		String str=null;
		Optional<Customer> customerObj=loginDao.findByEmailId(customer.getEmail());
		if (!customerObj.isPresent()) {
			System.out.println(customerObj);
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = customerObj.get().getPassword();
			if (!pwd.equals(customer.getPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				str = "Sign in sucessfull";
				loginDao.saveAndFlush(customerObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}
	@Override
	public String changePassword(Login customer, String newPassword) {
		String str = null;
		Optional<Customer> customerObj = loginDao.findByEmailId(customer.getEmail());
		if (!customerObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = customerObj.get().getPassword();
			if (!pwd.equals(customer.getPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				customerObj.get().setPassword(newPassword);
				loginDao.saveAndFlush(customerObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}



}
