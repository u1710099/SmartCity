package com.idigital.epam.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.idigital.epam.energy.dao.AdminDao;
import com.idigital.epam.energy.dao.BillDetailsDao;
import com.idigital.epam.energy.dao.CustomerDao;
import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.entity.Bill;
import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.BillException;

@Service
public class BillDetailsServiceImpl implements BillDetailsService{

	@Autowired
	private BillDetailsDao billDetailsDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private AdminDao adminDao;



	@Override
	public Integer addBill(Bill bill) throws BillException {
		BillDetails billDetails=new BillDetails();
		Integer custId=bill.getCustId();
		Integer adminId=bill.getAdminId();
		Integer prevReading = bill.getPreviousReading();
		Integer currReading = bill.getCurrentReading();
		Integer totalReading = currReading - prevReading ;
		Double fixCharge = bill.getFixCharge();
		Double totalCost = fixCharge * totalReading;
		try {
			billDetails.setMeterId(bill.getMeterId());
			billDetails.setFixCharge(bill.getFixCharge());
			billDetails.setPreviousReading(prevReading);
			billDetails.setCurrentReading(currReading);
			billDetails.setTotalUnit(totalReading);
			billDetails.setStartDate(bill.getStartDate());
			billDetails.setEndDate(bill.getEndDate());
			billDetails.setMonth(bill.getMonth());
			billDetails.setTotalCharge(totalCost);
			billDetails.setPaymentStatus(bill.getPaymentStatus());
			if(custId!=null) {
				Optional<Customer> optional=customerDao.findById(custId);
				if(optional.isPresent()) {
					billDetails.setCustomer(optional.get());
				}
			}
			if(adminId!=null) {
				Optional<Admin> optional=adminDao.findById(adminId);
				if(optional.isPresent()) {
					billDetails.setAdmin(optional.get());
				}
			}
			String email=customerDao.findEmailbyId(custId);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("Electricity Bill for " + bill.getMonth());
			mailMessage.setFrom("xxx@gmail.com");
			mailMessage.setText("Hi,\n This is to inform you that your"+" "+bill.getMonth()+" "+
					"bill is added.please check your dashboard for futher details.\n If any query then contact us");

			emailSenderService.sendEmail(mailMessage);
			billDetailsDao.save(billDetails);
			return 1;

		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}
	}

	@Override
	public BillDetails getBillById(Integer id) throws BillException {
		try {
			Optional<BillDetails> optional=billDetailsDao.findById(id);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}
		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}

	}

	@Override
	public Integer deleteBill(Integer id) throws BillException {
		try {
			billDetailsDao.deleteById(id);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}
	}

	@Override
	public List<BillDetails> getAllBill() throws BillException {
		try {
			List<BillDetails> billList=billDetailsDao.findAll();
			return billList;
		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}
	}

	@Override
	public BillDetails updateBill(BillDetails billDetails) throws BillException {
		try {
			BillDetails update=billDetailsDao.save(billDetails);
			return update;
		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}
	}

	@Override
	public List<BillDetails> getBillOfCustomer(String email) throws BillException {
		List<BillDetails> billList=null;
		try {
			Optional<Customer> optional=customerDao.getDataByEmail(email);
			if(optional.isPresent()) {
				billList=billDetailsDao.findbyCustEmail(optional.get());
				if(billList.size()==0) {
					throw new BillException("No data found");
				}
				return billList;

			}else {
				throw new BillException();
			}


		}catch(DataAccessException dataAccessException) {
			throw new BillException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new BillException(exception.getMessage(),exception);
		}


	}





}