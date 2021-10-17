package com.idigital.epam.energy.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
	private Integer id;
	
	@Column(name="cust_first_name")
	private String firstName;
	
	@Column(name="cust_last_name")
	private String lastName;
	
	@Column(name="cust_email")
	private String email;
	
	@Column(name="cust_mobile")
	private String mobile;
	
	@Column(name="password")
	private String password;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Column(name="account_activation")
	private Boolean isEnabled;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private Set<BillDetails> billDetail;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private Set<Payment> payment;

	public Customer(Integer id, String firstName, String lastName, String email, String mobile, String password,
			String address, String state, String city, String pincode, Boolean isEnabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.isEnabled = isEnabled;
	}

	public Customer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<BillDetails> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(Set<BillDetails> billDetail) {
		this.billDetail = billDetail;
	}

	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", address=" + address + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + ", isEnabled=" + isEnabled + "]";
	}
	
	
	
}
	