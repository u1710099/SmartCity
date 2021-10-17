package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.Login;

public interface LoginService {
	 public String signIn(Login customer);
	 public String changePassword(Login customer, String newPassword);

}