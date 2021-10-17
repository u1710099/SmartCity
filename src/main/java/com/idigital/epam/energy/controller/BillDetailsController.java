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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idigital.epam.energy.entity.Bill;
import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.exception.BillException;
import com.idigital.epam.energy.service.BillDetailsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/billDetails")
@CrossOrigin("http://localhost:3000")
public class BillDetailsController {

	@Autowired
	private BillDetailsService billDetailsService;

	@ApiOperation(value = "Get Bill by Id",response = BillDetails.class,
			tags="get-bill-by-id",consumes="id",httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<BillDetails> getBillById(@PathVariable Integer id){
		try {
			BillDetails billDetails = billDetailsService.getBillById(id);
			return new ResponseEntity<>(billDetails,HttpStatus.OK);
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}

	}

	@ApiOperation(value = "Get all bills",response = BillDetails.class,
			tags="get-all-bills",httpMethod = "GET")
	@GetMapping("/")
	public ResponseEntity<List<BillDetails>> getAllBill(){
		try {
			List<BillDetails> billList=billDetailsService.getAllBill();
			return new ResponseEntity<>(billList,HttpStatus.OK);
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}
	}

	@ApiOperation(value = "Delete Bill",consumes = "id",
			response =String.class)
	@DeleteMapping("/{id}")
	public String deleteBill(@PathVariable Integer id) {
		try {
			Integer status=billDetailsService.deleteBill(id);
			if(status==1) {
				return "bill: "+id+" deleted from database";
			}
			else {
				return "Unable to delete bill from database";
			}
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}
	}

	@ApiOperation(value = "Update Bill",
			consumes = "receives BillDetails object as request body",
			response =BillDetails.class)
	@PutMapping("/")
	public ResponseEntity<BillDetails> updateBill(@RequestBody BillDetails billDetails){
		try {
			BillDetails updatedBill=billDetailsService.updateBill(billDetails);
			return new ResponseEntity<>(updatedBill,HttpStatus.OK);
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}
	}

	@ApiOperation(value = "Add Bill",
			consumes = "receives Bill object as request body",
			response =String.class)
	@PostMapping("/add")
	public String addBill(@RequestBody Bill bill) {

		try {
			Integer status = billDetailsService.addBill(bill);
			if(status!=0) {
				return "Bill Added to database. ";
			}
			else {
				return "Unable to add Bill to database" ;
			}
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}
	}

	//Customer can see his own bills only
	@ApiOperation(value = "Get all bills of a customer",response = BillDetails.class,
			tags="get-all-bills-customer",httpMethod = "GET")
	@GetMapping("/customer/{email}")
	public List<BillDetails> getBillDetails(@PathVariable String email){
		try {
			List<BillDetails> billDetails=billDetailsService.getBillOfCustomer(email);
			return billDetails;
		}catch(BillException billException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,billException.getMessage());
		}
	}
}