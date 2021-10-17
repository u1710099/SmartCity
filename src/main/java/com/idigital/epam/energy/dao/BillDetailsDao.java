package com.idigital.epam.energy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.entity.Customer;

public interface BillDetailsDao extends JpaRepository<BillDetails, Integer>{
	@Query(value="From BillDetails bd where bd.customer=?1")
	List<BillDetails> findbyCustEmail(Customer customer);
	@Query(value="select bd from BillDetails bd where bd.id=?1")
	BillDetails findDatabyBillId(Integer id);

}