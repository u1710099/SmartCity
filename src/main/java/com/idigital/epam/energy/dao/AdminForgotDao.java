package com.idigital.epam.energy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Admin;

public interface AdminForgotDao extends JpaRepository<Admin, Integer>{

	@Query("select a from Admin a where a.adminEmail=?1")
	Optional<Admin> findByEmailId(String adminEmail);

}




