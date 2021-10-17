package com.idigital.epam.energy.service;
import com.idigital.epam.energy.entity.AdminLogin;

public interface AdminLoginService {
	 public String adminSignIn(AdminLogin admin);
	 public String changePassword(AdminLogin admin, String newPassword);


}