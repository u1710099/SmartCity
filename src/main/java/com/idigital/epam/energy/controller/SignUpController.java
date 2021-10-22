//package com.idigital.epam.energy.controller;
//
//import com.idigital.epam.energy.repository.UserRepository;
//import com.idigital.epam.energy.entity.User;
//import com.idigital.epam.energy.entity.CitizenResponse;
//import com.idigital.epam.energy.service.CitizenManagModuleConnectorServiceImpl;
//import com.idigital.epam.energy.service.UserService;
//
//import org.springframework.ui.Model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class SignUpController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    CitizenManagModuleConnectorServiceImpl connectorService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/register")
//    public String showSignUpForm(Model model){
//        model.addAttribute("user", new User());
//        return "signup_form";
//    }
//
//    @PostMapping("/process_register")
//    public ModelAndView processRegistration(User user){
//        ModelAndView modelAndView = new ModelAndView();
//
//        CitizenResponse response = connectorService.getCitizenAccountInfo(user.getCitizen_card_id());
//        if(response != null){
//            if(response.getResult().getFirstName().equals(user.getFirstName()) && response.getResult().getLastName().equals(user.getLastName())){
//                if(response.getResult().isActive() == true){
//                    userService.saveUserWithDefaultRole(user);
//                    modelAndView.setViewName("register_success");
//                }
//                else {
//                    modelAndView.addObject("message", "The citizen with the given card number blocked. Please, check your account status in Citizen Management Module");
//                    modelAndView.setViewName("register_failure");
//                }
//            }
//            else{
//                modelAndView.addObject("message", "The entered First and Last Name does not match the Name of the Card Owner");
//                modelAndView.setViewName("signup_form");
//            }
//        }
//        else{
//            modelAndView.addObject("message", "The citizen with the given card number does not exit. Make sure you've registered in Citizen Management Module");
//            modelAndView.setViewName("register_failure");
//        }
//
//        return modelAndView;
//    }
//
//    @GetMapping("/success_url")
//    public String successUrl(){
//        return "success_url";
//    }
//
//}
