package com.inyange.inyange.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inyange.inyange.model.User;
import com.inyange.inyange.service.UserService;
@Controller
public class testController {
	@Autowired
	private UserService userService;
	@GetMapping("/layout")
	public String Strtest(Model model,Authentication authentication) {
		String findUserName=authentication.getName();
		User user=userService.findByEmail(findUserName);
		// model.addAttribute("userLogged", user);
		return "layout";
	}
} 
