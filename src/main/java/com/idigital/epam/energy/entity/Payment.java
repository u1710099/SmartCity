package com.idigital.epam.energy.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
	private Integer id;
	
	@Column(name = "card_number")
	private Long cardNumber;
	
	@Column(name = "card_holder_name")
	private String cardHolderName;
	
	@Column(name = "cvv")
	private Integer cvv;
	
	@Column(name = "card_expiry_date")
	private LocalDate cardExpiryDate;
	
	@Column(name = "bill_amount")
	private Integer billAmount;
	
	@Column(name = "payment_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Payment() {
		
	}

	public Payment(Integer id, Long cardNumber, String cardHolderName, Integer cvv, LocalDate cardExpiryDate,
			Integer billAmount, LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.cardExpiryDate = cardExpiryDate;
		this.billAmount = billAmount;
		this.paymentDate = paymentDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public LocalDate getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(LocalDate cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public Integer getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	
}
