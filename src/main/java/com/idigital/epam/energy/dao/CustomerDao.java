package com.idigital.epam.energy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idigital.epam.energy.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	@Query("select cm from Customer cm where cm.email=?1")
	Customer findByEmailId(String email);
	
	@Query(value = "select cm.email from Customer cm where cm.id=?1")
	String findEmailbyId(Integer id);
	
	@Query("select cm from Customer cm where cm.email=?1")
	Optional<Customer> getDataByEmail(String email);

}