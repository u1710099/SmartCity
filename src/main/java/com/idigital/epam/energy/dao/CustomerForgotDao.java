package com.idigital.epam.energy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Customer;

public interface CustomerForgotDao extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email=?1")
	Optional<Customer> findByEmailId(String email);
}
