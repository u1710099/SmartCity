package com.idigital.epam.energy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
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

import com.idigital.epam.energy.entity.Bill;
import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.service.BillDetailsServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class BillDetailsControllerTest {

	@Mock
	private BillDetailsServiceImpl billDetailsServiceImpl;
	@InjectMocks
	private BillDetailsController BillDetails;

	private final Integer id=1;
	private final String meterId = "1234";
	private final double fixCharge = 10;
	private final double totalCharge = 2000;
	private final Integer totalUnit = 200;
	private final Integer previousReading =300;
	private final Integer currentReading= 500;
	private final String paymentStatus = "unpaid";
	private final LocalDate startDate = LocalDate.of(2021, Month.APRIL, 02);    // 2021-04-02
	private final LocalDate endDate = LocalDate.of(2021, Month.MAY, 02);    	// 2021-05-02
	private final String month= "Fabruary";

	private final Integer custId = 1;



	@Test
	void testGetBillById() throws Exception{
		BillDetails billDetails =new BillDetails();
		billDetails.setId(id);
		Mockito.when(billDetailsServiceImpl.getBillById(id)).thenReturn(billDetails);
		// Execute the GET request
		ResponseEntity<BillDetails> id = BillDetails.getBillById(custId);

		//validate response
		assertEquals(id.getStatusCodeValue(), 200);
	}

	@Test
	void testGetAllBill() throws Exception{
		BillDetails billDetails=new BillDetails();
		List<BillDetails> billList=new ArrayList<BillDetails>();

		billList.add(billDetails);
		Mockito.when(billDetailsServiceImpl.getAllBill()).thenReturn(billList);
		// Execute the GET request
		ResponseEntity<List<BillDetails>> list=BillDetails.getAllBill();

		// Validate the response code 
		assertEquals(list.getStatusCodeValue(), 200);
	}

	@Test
	void testDeleteBill() throws Exception{
		Mockito.when(billDetailsServiceImpl.deleteBill(id)).thenReturn(1);

		//Execute Delete request
		String deleted=BillDetails.deleteBill(custId);

		//validate response
		assertEquals(deleted, "bill: "+id+" deleted from database");
	}

	@Test
	void testUpdateBill() throws Exception{
		BillDetails billDetails=new BillDetails();
		billDetails.setId(id);
		billDetails.setMeterId("5678");
		Mockito.when(billDetailsServiceImpl.updateBill(billDetails)).thenReturn(billDetails);

		//Execute Update request
		ResponseEntity<BillDetails> updated=BillDetails.updateBill(billDetails);
		assertEquals(updated.getStatusCodeValue(),200 );
	}

	@Test
	void testAddBill() throws Exception{
		Bill bill=new Bill();
		bill.setId(id);
		bill.setMeterId(meterId);
		bill.setFixCharge(fixCharge);
		bill.setPreviousReading(previousReading);
		bill.setCurrentReading(currentReading);
		bill.setStartDate(startDate);
		bill.setEndDate(endDate);


		Mockito.when(billDetailsServiceImpl.addBill(bill)).thenReturn(1);

		//Execute Post request
		String respose=BillDetails.addBill(bill);
		assertEquals(respose, "Bill Added to database. ");
	}

}
