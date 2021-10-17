package com.idigital.epam.energy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.entity.Payment;

public interface PaymentDetailsDao extends JpaRepository<Payment, Integer>{
	@Query(value="From Payment p where p.customer=?1")
	List<Payment> findbyCustEmail(Customer customer);
	@Query(value="select p from Payment p where p.id=?1")
	Payment findDatabyBillId(Integer id);

}
