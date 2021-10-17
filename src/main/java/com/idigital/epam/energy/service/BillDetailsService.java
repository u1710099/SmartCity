package com.idigital.epam.energy.service;

import java.util.List;

import com.idigital.epam.energy.entity.Bill;
import com.idigital.epam.energy.entity.BillDetails;
import com.idigital.epam.energy.exception.BillException;

public interface BillDetailsService {

	
	public Integer addBill(Bill bill) throws BillException;
	public BillDetails getBillById(Integer id) throws BillException;
	public Integer deleteBill(Integer id) throws BillException;
	public List<BillDetails> getAllBill() throws BillException;
	public BillDetails updateBill(BillDetails billDetails)throws BillException;
	public List<BillDetails> getBillOfCustomer(String email) throws BillException;
	
}