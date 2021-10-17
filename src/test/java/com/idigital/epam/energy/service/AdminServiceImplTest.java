package com.idigital.epam.energy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.idigital.epam.energy.dao.AdminDao;
import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.exception.AdminException;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

	@Mock
	private AdminDao adminDao;
	@InjectMocks
	private AdminServiceImpl adminService;

	private final Integer adminId=1;
	private final String adminFirstName="Sonal";
	private final String adminLastName="Kaminwar";
	private final String adminEmail="Sonal@gmail.com";
	private final String adminMobile="9374885647";
	private final String adminPassword="Sonal#23";

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

	@Test
	void testGetAdminById() throws AdminException {
		Admin admin=new Admin();
		admin.setId(adminId);
		admin.setAdminFirstName(adminFirstName);
		admin.setAdminLastName(adminLastName);
		admin.setAdminEmail(adminEmail);
		admin.setAdminMobile(adminMobile);
		admin.setAdminPassword(adminPassword);
		adminService.getAdminById(adminId);
		verify(adminDao,times(1)).findById(adminId);
	}

	@Test
	void testAddAdmin() throws AdminException {
		Admin admin=new Admin();
		admin.setId(adminId);
		admin.setAdminFirstName(adminFirstName);
		admin.setAdminLastName(adminLastName);
		admin.setAdminEmail(adminEmail);
		admin.setAdminPassword(adminPassword);
		adminService.addAdmin(admin);
		verify(adminDao,times(1)).save(admin);	

	}

	@Test
	void testdeleteAdmin() throws AdminException  {
		Admin admin=new Admin();
		admin.setId(adminId);
		adminService.deleteAdmin(adminId);
		verify(adminDao,times(1)).deleteById(adminId);
	}

	@Test
	void testUpdateAdminProfile() throws AdminException {
		Admin admin=new Admin();
		admin.setId(adminId);
		admin.setAdminFirstName(adminFirstName);
		admin.setAdminLastName(adminLastName);
		admin.setAdminEmail(adminEmail);
		admin.setAdminMobile(adminMobile);
		admin.setAdminPassword(adminPassword);
		admin.setAdminFirstName("Priya");
		adminService.updateAdminProfile(admin);
		assertEquals("Priya", admin.getAdminFirstName());
	}



}
