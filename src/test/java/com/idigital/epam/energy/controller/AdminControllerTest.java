//package com.idigital.epam.energy.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.idigital.epam.energy.dao.ConfirmationTokenDao;
//import com.idigital.epam.energy.entity.Admin;
//import com.idigital.epam.energy.service.AdminServiceImpl;
//
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
//class AdminControllerTest {
//
//	@Mock
//	private ConfirmationTokenDao tokenDao;
//	@Mock
//	private AdminServiceImpl adminService;
//
//	@InjectMocks
//	private AdminController adminController;
//
//	private final Integer adminId=1;
//	private final String adminFirstName="John";
//	private final String adminLastName="Kam";
//	private final String adminEmail="john@gmail.com";
//	private final String adminMobile="1234567890";
//	private final String adminPassword="John#23";
//
//	@Test
//	void testAddAdmin() throws Exception {
//		Admin admin=new Admin();
//		admin.setId(adminId);
//		admin.setAdminFirstName(adminFirstName);
//		admin.setAdminLastName(adminLastName);
//		admin.setAdminEmail(adminEmail);
//		admin.setAdminMobile(adminMobile);
//		admin.setAdminPassword(adminPassword);
//		Mockito.when(adminService.addAdmin(admin)).thenReturn(admin);
//
//		//Execute Post request
//		ResponseEntity<Admin> a1=adminController.addAdmin(admin);
//		assertEquals(a1.getStatusCodeValue(), 201);
//
//	}
//
//	@Test
//	void testgetById() throws Exception {
//		Admin admin=new Admin();
//		admin.setId(adminId);
//		Mockito.when(adminService.getAdminById(adminId)).thenReturn(admin);
//		// Execute the GET request
//		ResponseEntity<Admin> id=adminController.getById(adminId);
//
//		//validate response
//		assertEquals(id.getStatusCodeValue(), 200);
//
//	}
//
//	@Test
//	void testDeleteAdmin() throws Exception {
//		Mockito.when(adminService.deleteAdmin(adminId)).thenReturn(1);
//
//		//Execute Delete request
//		String deleted=adminController.deleteAdmin(adminId);
//
//		//validate response
//		assertEquals(deleted, "admin: "+adminId+" deleted from database");
//	}
//
//	@Test
//	void editAdminDetails() throws Exception {
//		Admin admin=new Admin();
//
//		admin.setAdminFirstName(adminFirstName);
//		admin.setAdminLastName(adminLastName);
//		admin.setAdminMobile(adminMobile);
//		Mockito.when(adminService.addAdminDetails(admin, adminId)).thenReturn(admin);
//
//		//Execute Update request
//		ResponseEntity<Admin> add=adminController.addAdminDetails(admin, adminId);
//		assertEquals(add.getStatusCodeValue(),200 );
//	}
//
//	@Test
//	void testGetAdminIdByEmail() throws Exception {
//		Admin admin=new Admin();
//		admin.setAdminEmail(adminEmail);
//		Mockito.when(adminService.getAdminIdByEmail(adminEmail)).thenReturn(1);
//
//		//Execute Get request
//		Integer id=adminController.getAdminIdByEmail(adminEmail);
//		assertEquals(id, adminId);
//	}
//	@Test
//	void testUpdateAdminProfile() throws Exception {
//		Admin admin=new Admin();
//		admin.setId(adminId);
//		admin.setAdminFirstName("Moni");
//		Mockito.when(adminService.updateAdminProfile(admin)).thenReturn(admin);
//
//		//Execute Update request
//		ResponseEntity<Admin> updated=adminController.updateAdminProfile(admin);
//		assertEquals(updated.getStatusCodeValue(),200 );
//
//	}
//}
