package com.inyange.inyange.controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inyange.inyange.helper.RegistrationRequest;
import com.inyange.inyange.model.User;
import com.inyange.inyange.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public RegistrationRequest userRegistrationDto() {
        return new RegistrationRequest();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }
    @GetMapping("/api/addDistibutor")
	public String addInyange(Model model,Authentication authentication){
		String username=authentication.getName();
		User user =userService.findByEmail(username);
		model.addAttribute("userLogged",user);
		return "addDistributor";
	}
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") RegistrationRequest registrationDto) {
        try {

            userService.save(registrationDto);
        } catch (Exception e) {
            logger.error("An Error has occured while saving this user" + e);
        }

        return "redirect:/registration?success";
    }
     @PostMapping("/posted")
    public String registerUserAccounts(@ModelAttribute("user") RegistrationRequest registrationDto) {
        try {
            userService.save(registrationDto);
        } catch (Exception e) {
            logger.error("An Error has occured while saving this user" + e);
        }

        return "redirect:/registration/api/addDistibutor";
    }
    @GetMapping("/default")
    public String redirectAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/index";
        }else if(request.isUserInRole("USER")) {
            return "redirect:/indexInyange";
        }else if(request.isUserInRole("INYANGE")) {
            return "redirect:/indexInyange";
        }else {
            return "redirect:/login";
        }
    }
}
