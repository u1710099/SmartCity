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
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer id;

	@Column(name="admin_first_name")
	private String adminFirstName;

	@Column(name="admin_last_name")
	private String adminLastName;

	@Column(name="admin_email")
	private String adminEmail;

	@Column(name="admin_mobile")
	private String adminMobile;

	@Column(name="admin_password")
	private String adminPassword;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private Set<BillDetails> billDetail;
	
	public Set<BillDetails> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(Set<BillDetails> billDetail) {
		this.billDetail = billDetail;
	}

	public Admin() {
		super();
	}

	public Admin(Integer id, String adminFirstName, String adminLastName, String adminEmail, String adminMobile,
			String adminPassword) {
		super();
		this.id = id;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminEmail = adminEmail;
		this.adminMobile = adminMobile;
		this.adminPassword = adminPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


}
