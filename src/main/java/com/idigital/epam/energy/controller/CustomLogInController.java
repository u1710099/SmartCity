package com.idigital.epam.energy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLogInController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
