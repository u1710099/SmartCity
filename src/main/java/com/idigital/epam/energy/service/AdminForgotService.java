package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.AdminForgot;

public interface AdminForgotService {

	public String forgotPassword(AdminForgot admin, String newPassword);

}
