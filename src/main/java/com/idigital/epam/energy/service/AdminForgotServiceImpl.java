package com.idigital.epam.energy.service;

import static com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
import static com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;
import static com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
import static com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;

import java.util.Optional;

import com.idigital.epam.energy.dao.AdminForgotDao;
import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.entity.AdminForgot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.exception.OperationFailedException;
import com.idigital.epam.energy.exception.ResourceNotFound;

@Service
public class AdminForgotServiceImpl implements AdminForgotService{

	@Autowired
	private AdminForgotDao adminForgotDao;

	@Override
	public String forgotPassword(AdminForgot admin, String newPassword) {
		String str = null;
		Optional<Admin> userObj = adminForgotDao.findByEmailId(admin.getAdminEmail());

		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		}
		try {
			userObj.get().setAdminPassword(newPassword);
			adminForgotDao.saveAndFlush(userObj.get());
			str = "Password updated sucessfully";
		} catch (Exception e) {
			throw new OperationFailedException(OPERATION_FAILED);
		}
		return str;
	}

}
