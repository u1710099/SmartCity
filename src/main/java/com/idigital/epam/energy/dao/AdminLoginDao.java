package com.idigital.epam.energy.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Admin;



public interface AdminLoginDao extends JpaRepository<Admin, Integer>{
	@Query("select am from Admin am where am.adminEmail=?1")
	Optional<Admin> findByAdminEmail(String adminEmail);
}