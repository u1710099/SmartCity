package com.idigital.epam.energy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bill_details")

public class BillDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	private Integer id;

	@Column(name = "meter_id")
	private String meterId;

	@Column(name = "fix_charge")
	private Double fixCharge;

	@Column(name = "total_cost")
	private Double totalCharge;

	@Column(name = "total_unit")
	private Integer totalUnit;

	@Column(name = "previous_reading")
	private Integer previousReading;

	@Column(name = "current_reading")
	private Integer currentReading;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name="bill_month")
	private String month;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public BillDetails() {
		super();
	}

	public BillDetails(Integer id, String meterId, Double fixCharge, Double totalCharge, Integer totalUnit,
			Integer previousReading, Integer currentReading, String paymentStatus, LocalDate startDate,
			LocalDate endDate, String month) {
		super();
		this.id = id;
		this.meterId = meterId;
		this.fixCharge = fixCharge;
		this.totalCharge = totalCharge;
		this.totalUnit = totalUnit;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.paymentStatus = paymentStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.month = month;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}