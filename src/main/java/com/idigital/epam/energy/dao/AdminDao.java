package com.idigital.epam.energy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{
	@Query("select am from Admin am where am.adminEmail=?1")
	Admin findByAdminEmailId(String adminEmail);

	@Query(value = "select am.adminEmail from Admin am where am.id=?1")
	String findAdminEmailbyId(Integer id);

	@Query("select am from Admin am where am.adminEmail=?1")
	Optional<Admin> getAdminDataByEmail(String adminEmail);

}
