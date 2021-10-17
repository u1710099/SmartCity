package com.idigital.epam.energy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.idigital.epam.energy.dao.PaymentDetailsDao;
import com.idigital.epam.energy.entity.Payment;
import com.idigital.epam.energy.exception.PaymentException;


@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
	@Mock
	private PaymentDetailsDao paymentDao;
	@InjectMocks
	private PaymentServiceImpl paymentService;

	private final Integer Id=1;
	private final Long cardNumber=67688378232L;
	private final String cardHolderName="Kohli";
	private final Integer cvv=455;
	private final Integer  billAmount =320;

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
	}


	@Test
	void testGetPaymentById() throws PaymentException {
		Payment payment=new Payment();
		payment.setId(Id);
		payment.setCardNumber(cardNumber);
		payment.setCardHolderName(cardHolderName);
		payment.setCvv(cvv);
		payment.setBillAmount(billAmount);
		paymentService.getPaymentById(Id);

		verify(paymentDao,times(1)).findById(Id);

	}


	@Test
	void testDeletePayment() throws PaymentException  {
		Payment payment=new Payment();
		payment.setId(Id);
		paymentService.deletePayment(Id);
		verify(paymentDao,times(1)).deleteById(Id);
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

		Mockito.when(paymentDao.findAll()).thenReturn(payList);
		assertEquals(payList, paymentService.getAllPayment());
	}



}
