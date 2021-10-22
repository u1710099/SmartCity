package com.idigital.epam.energy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/api/v1/panel")
public class UserController {

    @GetMapping
    public String userTest(){
        return "User Controller";
    }
}
