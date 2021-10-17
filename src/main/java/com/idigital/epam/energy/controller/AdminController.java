package com.idigital.epam.energy.controller;

import com.idigital.epam.energy.entity.Admin;
import com.idigital.epam.energy.exception.AdminException;
import com.idigital.epam.energy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;

@RestControllerAdvice
@RequestMapping(value = "/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	@Autowired
	private AdminService adminService;

	//Add admin details
	@ApiOperation(value = "Add Admin",
			consumes = "receives Admin object as request body",
			response =String.class)
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		try {
			Admin a1= adminService.addAdmin(admin);
			return new ResponseEntity<Admin>(a1, HttpStatus.CREATED);
		}catch(AdminException adminException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}

	//Get admin by Id
	@ApiOperation(value = "Get Admin by Id",response = Admin.class,
			tags="get-admin-by-id",consumes="adminId",httpMethod = "GET")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> getById(@PathVariable Integer id) {
		try {
			Admin admin = adminService.getAdminById(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);

		}catch(AdminException adminException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}

	//Get admin Id by admin Email Id
	@ApiOperation(value = "Get admin id by email",response = Admin.class,
			tags="get-admin-id-by-email",consumes="adminEmail",httpMethod = "GET")
	@GetMapping("/adminEmail/{adminEmail}")
	public Integer getAdminIdByEmail(@PathVariable String adminEmail) {
		try {
			Integer id=adminService.getAdminIdByEmail(adminEmail);
			if(id!=null) {
				return id;
			}else
			{
				return 0;
			}
		}catch(AdminException adminException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}


	//Delete admin details
	@ApiOperation(value = "Delete Admin",consumes = "adminId",
			response =String.class)
	@DeleteMapping(value = "/{id}")
	public String deleteAdmin(@PathVariable Integer id) {
		try {
			Integer status=adminService.deleteAdmin(id);
			if(status==1) {
				return "admin: "+id+" deleted from database";
			}
			else {
				return "Unable to delete admin from database";
			}
		}catch(AdminException adminException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}

	//edit admin details 
	@ApiOperation(value = "Add More Information Of Admin",
			consumes = "receives Admin object as request body",
			response =Admin.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<Admin> addAdminDetails(@RequestBody Admin admin, @PathVariable Integer id) {
		try {
			Admin adminedit = adminService.addAdminDetails(admin,id);
			return new ResponseEntity<>(adminedit, HttpStatus.OK);
		}catch(AdminException adminException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}

	@ApiOperation(value = "Update Admin",
			consumes = "receives Admin object as request body",
			response =Admin.class)
	@PutMapping("/")
	public ResponseEntity<Admin> updateAdminProfile(@RequestBody Admin admin){
		try {
			Admin updatedAdmin=adminService.updateAdminProfile(admin);
			return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
		}catch(AdminException adminException) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,adminException.getMessage());
		}
	}
}
