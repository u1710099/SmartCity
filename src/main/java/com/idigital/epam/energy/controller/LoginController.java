package com.idigital.epam.energy.controller;

import com.idigital.epam.energy.entity.Login;
import com.idigital.epam.energy.exception.BaseResponse;
import com.idigital.epam.energy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customerLogin")
@CrossOrigin("http://localhost:3000")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@ApiOperation(value = "Login Customer",
			consumes = "receives Customer object as request body",
			response =String.class)
	@PostMapping(value="/login")
	public ResponseEntity<?> signIn( @RequestBody Login customer){
		String str=loginService.signIn(customer);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);

	}

	@ApiOperation(value = "Reset Password",
			consumes = "receives password object as request body",
			response =String.class)
	@PostMapping("/reset/{newPassword}")
	public ResponseEntity<?> changePassword( @RequestBody Login customer, @PathVariable String newPassword) {
		String str =loginService.changePassword(customer, newPassword);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}
