
package com.idigital.epam.energy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.dao.BillDetailsDao;
import com.idigital.epam.energy.dao.CustomerDao;
import com.idigital.epam.energy.dao.PaymentDetailsDao;
import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.entity.Payment;
import com.idigital.epam.energy.exception.BillException;
import com.idigital.epam.energy.exception.PaymentException;


@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	@Autowired
	private BillDetailsDao billDao;
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Payment addPayment(Payment payment,Integer billId) throws PaymentException {
		Payment paymentDetails=new Payment();
		try {
			paymentDetails.setId(payment.getId());
			paymentDetails.setCardNumber(payment.getCardNumber());
			paymentDetails.setCardHolderName(payment.getCardHolderName());
			paymentDetails.setCvv(payment.getCvv());
			paymentDetails.setCardExpiryDate(payment.getCardExpiryDate());
			paymentDetails.setBillAmount(payment.getBillAmount());
			paymentDetails.setPaymentDate(LocalDateTime.now());

			BillDetails data=billDao.findDatabyBillId(billId);
			Integer custId=data.getCustomer().getId();
			if(custId!=null) {
				Optional<Customer> optional=customerDao.findById(custId);
				if(optional.isPresent()) {
					paymentDetails.setCustomer(optional.get());
				}
			}
			if(data!=null) {
				data.setPaymentStatus("Paid");
			}

			paymentDetailsDao.save(paymentDetails);


			return paymentDetails;

		}catch(DataAccessException dataAccessException) {
			throw new PaymentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new PaymentException(exception.getMessage(),exception);
		}	
	}

	@Override
	public Payment getPaymentById(Integer id) throws PaymentException {

		try {
			Optional<Payment> optional=paymentDetailsDao.findById(id);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}
		}catch(DataAccessException dataAccessException) {
			throw new PaymentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new PaymentException(exception.getMessage(),exception);
		}
	}

	@Override
	public Integer deletePayment(Integer id) throws PaymentException {

		try {
			paymentDetailsDao.deleteById(id);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new PaymentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new PaymentException(exception.getMessage(),exception);
		}
	}

	@Override
	public List<Payment> getAllPayment() throws PaymentException {
		try {
			List<Payment> payList=paymentDetailsDao.findAll();
			return payList;
		}catch(DataAccessException dataAccessException) {
			throw new PaymentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new PaymentException(exception.getMessage(),exception);
		}

	}

	@Override
	public List<Payment> getPaymentOfCustomer(String email) throws PaymentException {
		List<Payment> paymentList=null;
		try {
			Optional<Customer> optional=customerDao.getDataByEmail(email);
			if(optional.isPresent()) {
				paymentList=paymentDetailsDao.findbyCustEmail(optional.get());
				if(paymentList.size()==0) {
					throw new BillException("No data found");
				}
				return paymentList;

			}else {
				throw new PaymentException();
			}
		}catch(DataAccessException dataAccessException) {
			throw new PaymentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new PaymentException(exception.getMessage(),exception);
		}
	}
}