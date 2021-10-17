package com.idigital.epam.energy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Customer;

public interface LoginDao extends JpaRepository<Customer, Integer> {
	@Query("select cm from Customer cm where cm.email=?1 and cm.isEnabled='t' ")
	Optional<Customer> findByEmailId(String email);

}