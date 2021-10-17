package com.idigital.epam.energy.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.idigital.epam.energy.dao.ConfirmationTokenDao;
import com.idigital.epam.energy.entity.Payment;
import com.idigital.epam.energy.service.PaymentServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {
	@Mock
	private ConfirmationTokenDao tokenDao;
	@Mock
	private PaymentServiceImpl paymentService;
	@InjectMocks
	private PaymentsController paymentController;

	private final Integer Id=1;
	private final Long cardNumber=67688378232L;
	private final String cardHolderName="Kohli";
	private final Integer cvv=455;
	private final Integer  billAmount =320;

	@Test
	void testAddPayment() throws Exception {
		Payment payment=new Payment();
		payment.setId(Id);
		payment.setCardNumber(cardNumber);
		payment.setCardHolderName(cardHolderName);
		payment.setCvv(cvv);
		payment.setBillAmount(billAmount);
		Mockito.when(paymentService.addPayment(payment, Id)).thenReturn(payment);

		//Execute Post request
		String respose=paymentController.savePayment(payment, Id);
		assertEquals(respose, "Payment is Successful");

	}    

	@Test
	void testGetPaymentById() throws Exception {
		Payment payment=new Payment();
		payment.setId(Id);
		Mockito.when(paymentService.getPaymentById(Id)).thenReturn(payment);
		// Execute the GET request
		ResponseEntity<Payment> id=paymentController.getPaymentById(Id);

		//validate response
		assertEquals(id.getStatusCodeValue(), 200);

	}

	@Test
	void testGetAllPayment() throws Exception {
		Payment payment=new Payment();
		payment.setId(Id);
		payment.setCardNumber(cardNumber);
		payment.setCardHolderName(cardHolderName);
		payment.setCvv(cvv);
		payment.setBillAmount(billAmount);
		List<Payment> payList=new ArrayList<Payment>();
		payList.add(payment);
		Mockito.when(paymentService.getAllPayment()).thenReturn(payList);
		// Execute the GET request
		ResponseEntity<List<Payment>> list=paymentController.getAllPayment();

		// Validate the response code 
		assertEquals(list.getStatusCodeValue(), 200);
	}

	@Test
	void testDeletePayment() throws Exception {
		Mockito.when(paymentService.deletePayment(Id)).thenReturn(1);

		//Execute Delete request
		String deleted=paymentController.deletePayment(Id);

		//validate response
		assertEquals(deleted, "payment: "+Id+" deleted from database");
	}



}
