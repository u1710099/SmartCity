package com.idigital.epam.energy.service;

import java.util.List;

import com.idigital.epam.energy.entity.Payment;
import com.idigital.epam.energy.exception.PaymentException;



public interface PaymentService {


	public Payment addPayment(Payment payment,Integer billId) throws PaymentException;
	public Payment getPaymentById(Integer id) throws PaymentException;
	public Integer deletePayment(Integer id) throws PaymentException;
	public List<Payment> getAllPayment() throws PaymentException;
	public List<Payment> getPaymentOfCustomer(String email) throws PaymentException;

}
