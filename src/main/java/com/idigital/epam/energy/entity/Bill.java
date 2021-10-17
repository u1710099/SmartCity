package com.idigital.epam.energy.entity;

import java.time.LocalDate;

public class Bill {
	private Integer id;
	private String meterId;
	private Double fixCharge;
	private Double totalCharge;
	private Integer totalUnit;
	private Integer previousReading;
	private Integer currentReading;
	private String paymentStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private String month;
	private Integer custId;
	private Integer adminId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Double getFixCharge() {
		return fixCharge;
	}
	public void setFixCharge(Double fixCharge) {
		this.fixCharge = fixCharge;
	}
	public Double getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}
	public Integer getTotalUnit() {
		return totalUnit;
	}
	public void setTotalUnit(Integer totalUnit) {
		this.totalUnit = totalUnit;
	}
	public Integer getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(Integer previousReading) {
		this.previousReading = previousReading;
	}
	public Integer getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(Integer currentReading) {
		this.currentReading = currentReading;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
	

}
