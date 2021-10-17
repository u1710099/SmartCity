package com.idigital.epam.energy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idigital.epam.energy.dao.ConfirmationTokenDao;
import com.idigital.epam.energy.entity.ConfirmationToken;
import com.idigital.epam.energy.entity.Customer;
import com.idigital.epam.energy.exception.CustomerException;
import com.idigital.epam.energy.service.CustomerRegistration;
import com.idigital.epam.energy.service.EmailSenderService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerRegistrationController {
	@Autowired
	private ConfirmationTokenDao confirmationTokenDao;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private CustomerRegistration customerRegistration;
	
    @ApiOperation(value = "Add Customer",
            consumes = "receives Customer object as request body",
            response =String.class)
	@PostMapping(value="/",consumes = "application/json")
	public String addCustomer(@RequestBody Customer customer) {
		try {
			Integer status=customerRegistration.addCustomer(customer);
			ConfirmationToken token=new ConfirmationToken(customer);
			confirmationTokenDao.save(token);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(customer.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("xxx@gmail.com");
			mailMessage.setText("To confirm your account, please click here : "
					+"http://localhost:8081/springfox/api/customer/confirm-account?token="+token.getConfirmationToken());
			emailSenderService.sendEmail(mailMessage);
			if(status==1) {
				return "Registration successfull check email for confirmation";

			}else {
				return "Unable to add customer to database";
			}
		}catch(CustomerException customerException)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
		}
	}

    @ApiOperation(value = "Get confirm account",response = ConfirmationToken.class,
            tags="get-confirm-account",httpMethod = "GET")
	@GetMapping("/confirm-account")
	public String confirmAccount(@RequestParam("token") String confirmationToken) throws CustomerException {
		ConfirmationToken token=confirmationTokenDao.findByConfirmationToken(confirmationToken);
		if(token != null)
		{
			Customer customer = customerRegistration.findEmail(token.getCustomer().getEmail());
			return "Account verified";
		}
		else
		{	
			return "account not verified";
		}

	}


}
