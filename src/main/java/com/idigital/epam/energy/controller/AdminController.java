package com.idigital.epam.energy.controller;

import com.idigital.epam.energy.hmac.HMACUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("admin/api/v1/panel")
public class AdminController {

	@Autowired
	private HMACUtils hmACUtils;
	@GetMapping
	public ResponseEntity<?> adminTest() throws URISyntaxException {
		return hmACUtils.getRequestWithHmac("ENERGY", "get_homes", "http://citymanagementfull-env.eba-tixcjyas.us-east-2.elasticbeanstalk.com/api/v1/request/homesWithOwner", "energyKey");
	}
}
