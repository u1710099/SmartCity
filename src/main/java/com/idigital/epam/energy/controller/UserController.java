package com.idigital.epam.energy.controller;

import com.idigital.epam.energy.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/customer")

public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public ResponseEntity <Customer> getAllCustomer(@PathVariable String cardNumber){

        try {
            Customer custList= restTemplate.postForObject("http//:localhost:8080/card/{cardNumber}",cardNumber, Customer.class);
            return new ResponseEntity<>(custList, HttpStatus.OK);
        }catch(Exception customerException)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,customerException.getMessage());
        }
    }



}
