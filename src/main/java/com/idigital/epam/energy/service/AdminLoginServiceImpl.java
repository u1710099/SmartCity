package com.idigital.epam.energy.service;
import static com.idigital.epam.energy.exception.AppConstants.OPERATION_FAILED;
import static com.idigital.epam.energy.exception.AppConstants.USER_NOT_FOUND;
import static com.idigital.epam.energy.exception.AppConstants.WRONG_PASSWORD;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.dao.AdminLoginDao;
import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.entity.AdminLogin;
import com.idigital.epam.energy.exception.OperationFailedException;
import com.idigital.epam.energy.exception.ResourceNotFound;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminLoginDao adminLoginDao;
	@Override
	public String adminSignIn(AdminLogin admin) {
		String str=null;
		Optional<Admin> adminObj=adminLoginDao.findByAdminEmail(admin.getAdminEmail());
		if (!adminObj.isPresent()) {
			System.out.println(adminObj);
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = adminObj.get().getAdminPassword();
			if (!pwd.equals(admin.getAdminPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				str = "Sign in sucessfull";
				adminLoginDao.saveAndFlush(adminObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;

	}

	@Override
	public String changePassword(AdminLogin admin, String newPassword) {

		String str = null;
		Optional<Admin> adminObj = adminLoginDao. findByAdminEmail(admin.getAdminEmail());
		if (!adminObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = adminObj.get().getAdminPassword();
			if (!pwd.equals(admin.getAdminPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				adminObj.get().setAdminPassword(newPassword);
				adminLoginDao.saveAndFlush(adminObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

}