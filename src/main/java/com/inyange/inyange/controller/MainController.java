package com.inyange.inyange.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inyange.inyange.model.User;
import com.inyange.inyange.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	Logger logger= LoggerFactory.getLogger(this.getClass());
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String home(Model model,Authentication authentication) {
		String findUserName=authentication.getName();
		User user=userService.findByEmail(findUserName);
		// List<Category>category=categoryService.getAllCategories();
		// List<String>categoryName=new ArrayList<>();
		// for (Category cat:category
		// 	 ) {
		// 	categoryName.add(cat.getCategoryName());
		// }
		// List<Integer>expenseNumber=new ArrayList<>();
		// for (Category cat:category
		// ) {
		// 	expenseNumber.add(cat.getExpense().size());
		// }
		// model.addAttribute("categoryName",categoryName);
		// model.addAttribute("expenseNumber",expenseNumber);
		// model.addAttribute("category",categoryService.getAllCategories().size());
		// model.addAttribute("expense",expenseImpl.findAllExpenses(user.getId()).size());
		model.addAttribute("userLogged", user);
		return "index";
	}

	@GetMapping("/indexInyange")
	public String homes(Model model,Authentication authentication) {
		String findUserName=authentication.getName();
		User user=userService.findByEmail(findUserName);
		// List<Category>category=categoryService.getAllCategories();
		// List<String>categoryName=new ArrayList<>();
		// for (Category cat:category
		// 	 ) {
		// 	categoryName.add(cat.getCategoryName());
		// }
		// List<Integer>expenseNumber=new ArrayList<>();
		// for (Category cat:category
		// ) {
		// 	expenseNumber.add(cat.getExpense().size());
		// }
		// model.addAttribute("categoryName",categoryName);
		// model.addAttribute("expenseNumber",expenseNumber);
		// model.addAttribute("category",categoryService.getAllCategories().size());
		// model.addAttribute("expense",expenseImpl.findAllExpenses(user.getId()).size());
		model.addAttribute("userLogged", user);
		return "indexInyange";
	}
	@GetMapping("/api/editProfile")
	public String editProfiletest(Authentication auth, Model model)
	{
		String findUsername=auth.getName();
		User user=userService.findByEmail(findUsername);
		if(user==null){
			logger.error("An error occured while fetching data for the specific user");
		}
		model.addAttribute("userLogged",user);
		return "edit-profile";
	}
	@GetMapping("/api/superAdmin")
    public String superAdmin(Model model,Authentication authentication){
	    String username=authentication.getName();
	    User user=userService.findByEmail(username);
	    model.addAttribute("userLogged",user);
	    model.addAttribute("userList",userService.findAllUsers());
	    model.addAttribute("userSize",userService.findAllUsers().size());
	    return "SuperAdmin";
    }
	// @GetMapping("/api/searchedUser/{id}")
	// public String getUserExpenses(@PathVariable(value = "id")long user_id,Model model){
	// 	User user=userService.getUserById(user_id);
	// 			if(user!=null){
	// 				List<Expense>expenses=user.getExpenses();
	// 				model.addAttribute("expenses",expenses);
	// 			}
	// 	return "userExpense";
	// }
}
