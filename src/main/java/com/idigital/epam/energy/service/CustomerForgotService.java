package com.idigital.epam.energy.service;

import com.idigital.epam.energy.entity.CustomerForgot;

public interface CustomerForgotService {

	public String forgotPassword(CustomerForgot customer, String newPassword);

}
