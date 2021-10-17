package com.idigital.epam.energy.controller;
import com.idigital.epam.energy.entity.AdminLogin;
import com.idigital.epam.energy.exception.BaseResponse;
import com.idigital.epam.energy.service.AdminLoginService;
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
@RequestMapping("/api/adminLogin")
@CrossOrigin("http://localhost:3000")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;

	@ApiOperation(value = "Login Admin",
			consumes = "receives Admin object as request body",
			response =String.class)
	@PostMapping(value="/login",consumes = "application/json")
	public ResponseEntity<?> adminSignIn( @RequestBody AdminLogin admin){
		String str=adminLoginService.adminSignIn(admin);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);

	}

	@ApiOperation(value = "Reset Password",
			consumes = "receives password object as request body",
			response =String.class)

	@PostMapping("/reset/{newPassword}")
	public ResponseEntity<?> changePassword( @RequestBody AdminLogin admin, @PathVariable String newPassword) {
		String str =adminLoginService.changePassword(admin, newPassword);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}


}
