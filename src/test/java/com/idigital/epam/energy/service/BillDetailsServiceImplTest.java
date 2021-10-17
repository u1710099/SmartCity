package com.idigital.epam.energy.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
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

import com.idigital.epam.energy.dao.AdminDao;
import com.idigital.epam.energy.dao.BillDetailsDao;
import com.idigital.epam.energy.entity.BillDetails;

@ExtendWith(MockitoExtension.class)
class BillDetailsServiceImplTest {
	@Mock
	private BillDetailsDao billDetailsDao;
	@InjectMocks
	private BillDetailsServiceImpl billDetailsService;
	@InjectMocks
	private CustomerRegistrationImpl customerRegistrationImpl;
	@InjectMocks
	private CustomerServiceImpl customerService;

	private AdminDao admindao;
	@InjectMocks
	private AdminServiceImpl adminService;

	private final Integer id=1;
	private final String meterId = "1234";
	private final Double fixCharge = 10.0;
	private final Integer previousReading =300;
	private final Integer currentReading= 500;
	private final LocalDate startDate = LocalDate.of(2021, Month.APRIL, 02);    // 2021-04-02
	private final LocalDate endDate = LocalDate.of(2021, Month.MAY, 02);    	// 2021-05-02
	private final String month= "Fabruary";
	private final Integer custId = 1;

	private final Integer adminId = 1;


	private final String firstName="Virat";
	private final String LastName="Kohli";
	private final String email="virat@gmail.com";
	private final String mobile="9852123265";
	private final String password="virat@123";
	private final String address="AK Road,Nagpur";
	private final String state="Maharashtra";
	private final String city="Nagpur";
	private final String pin="440012";

	private final String adminFirstName="Virat";
	private final String adminLastName="Kohli";
	private final String adminEmail = "admin@gmail.com";
	private final String adminMobile = "8529631234";
	private final String adminPassword = "admin123";
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

	@Test
	void testGetBillById() throws Exception{
		billDetailsService.getBillById(id);
		verify(billDetailsDao,times(1)).findById(id);

	}

	@Test
	void testDeleteBill() throws Exception  {
		BillDetails billDetails = new BillDetails();
		billDetails.setId(id);
		billDetailsService.deleteBill(id);
		verify(billDetailsDao,times(1)).deleteById(id);
	}
	@Test
	void testGetAllBill() throws Exception{
		BillDetails billDetails = new BillDetails();

		List<BillDetails> billList=new ArrayList<BillDetails>();

		billDetails.setId(id);
		billDetails.setMeterId(meterId);
		billDetails.setFixCharge(fixCharge);
		billDetails.setPreviousReading(previousReading);
		billDetails.setCurrentReading(currentReading);
		billDetails.setStartDate(startDate);
		billDetails.setEndDate(endDate);

		Mockito.when(billDetailsDao.findAll()).thenReturn(billList);
		assertEquals(billList, billDetailsService.getAllBill());
	}

	@Test
	void testUpdateBill() throws Exception {
		BillDetails billDetails = new BillDetails();
		billDetails.setId(id);
		billDetails.setMeterId("5678");

		billDetailsService.updateBill(billDetails);
		assertEquals("5678", billDetails.getMeterId());
	}
}
