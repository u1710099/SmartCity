package com.idigital.epam.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idigital.epam.energy.entity.Payment;
import com.idigital.epam.energy.exception.PaymentException;
import com.idigital.epam.energy.service.PaymentService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentsController {
	@Autowired
	private PaymentService paymentService;

	@ApiOperation(value = "Add Payment",
			consumes = "receives Customer object as request body",
			response =String.class)

	@PostMapping("/pay/{billId}")
	public String savePayment(@RequestBody Payment payment,@PathVariable Integer billId) {
		try {
			Payment pay= paymentService.addPayment(payment,billId);
			if(pay!=null) {
				return "Payment is Successful";
			}else {
				return "Payment is not Successful";
			}
		}catch(PaymentException paymentException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,paymentException.getMessage());
		}
	}
	@ApiOperation(value = "Get payment by Id",response = Payment.class,
			tags="get-payment-by-id",consumes="payId",httpMethod = "GET")

	@GetMapping("/pay/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id){
		try {
			Payment payment=paymentService.getPaymentById(id);
			return new ResponseEntity<>(payment,HttpStatus.OK);
		}catch(PaymentException paymentException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,paymentException.getMessage());
		}

	}
	@ApiOperation(value = "Get payment List",response = Payment.class,
			tags="get-payment-details-of-customer",httpMethod = "GET")

	@GetMapping("/payment/{email}")
	public List<Payment> getPaymentDetails(@PathVariable String email){
		try {
			List<Payment> payment=paymentService.getPaymentOfCustomer(email);
			return payment;
		}catch(PaymentException paymentException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,paymentException.getMessage());
		}
	}
	@ApiOperation(value = "Get all payment",response = Payment.class,
			tags="get-all-payment",httpMethod = "GET")

	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> getAllPayment(){
		try {
			List<Payment> payList=paymentService.getAllPayment();
			return new ResponseEntity<>(payList,HttpStatus.OK);
		}catch(PaymentException paymentException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,paymentException.getMessage());
		}
	}
	@ApiOperation(value = "Delete Payment",consumes = "payId",
			response =String.class)
	@DeleteMapping("/payment/{id}")
	public String deletePayment(@PathVariable Integer id) {
		try {
			Integer status=paymentService.deletePayment(id);
			if(status==1) {
				return "payment: "+id+" deleted from database";
			}
			else {
				return "Unable to delete payment from database";
			}
		}catch(PaymentException paymentException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,paymentException.getMessage());
		}
	}


}
