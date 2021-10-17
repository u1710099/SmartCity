package com.idigital.epam.energy.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="token")
public class ConfirmationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="token_id")
	private Long tokenid;

	@Column(name="confirmation_token")
	private String confirmationToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@ToString.Exclude
	@JsonIgnore
	@OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "cust_id")
	private Customer customer;

	public ConfirmationToken(Customer customer) {
		this.customer = customer;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

}