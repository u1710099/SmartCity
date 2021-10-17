package com.idigital.epam.energy.controller;

import com.idigital.epam.energy.entity.CustomerForgot;
import com.idigital.epam.energy.exception.BaseResponse;
import com.idigital.epam.energy.service.CustomerForgotService;
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
@RequestMapping("/api/forgotPassword")
@CrossOrigin("http://localhost:3000")
public class CustomerForgotController {

	@Autowired
	private CustomerForgotService customerForgotService;

	@ApiOperation(value = "Forgot Password",
			consumes = "receives password object as request body",
			response =String.class)
	@PostMapping("/{newPassword}")
	public ResponseEntity<?> forgotPassword(@RequestBody CustomerForgot customer, @PathVariable String newPassword) {
		String str =customerForgotService.forgotPassword(customer, newPassword);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}
