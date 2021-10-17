package com.idigital.epam.energy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idigital.epam.energy.entity.ConfirmationToken;

public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken, String> {
	 ConfirmationToken findByConfirmationToken(String confirmationToken);
}