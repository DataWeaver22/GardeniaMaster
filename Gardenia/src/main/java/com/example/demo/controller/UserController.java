package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/user")
	public String listUser(Model model){
		model.addAttribute("user",userService.getAllUser());
		return "user";
	}
	
	@GetMapping("/user/new")
	public String CreateNewForm(Model model){
		//Create student object to hold student form data
		User user = new User();
		model.addAttribute("user",user);
		return "create_user";
	}
	
	@PostMapping("/user")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user";
	}
	
	@GetMapping("/user/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "edit_user";
	}
	
	@PostMapping(value = "/User") 
	public String populateList(Model model) {
	    List<String> options = new ArrayList<String>();
	    options.add("option 1");
	    options.add("option 2");
	    options.add("option 3");
	    model.addAttribute("options", options);
	    return "user";
	}
	
	@PostMapping("/user/{id}")
	public String updateUser(@PathVariable Long id,
			@ModelAttribute("hquser") User user,
			Model model) {
		
		//Get Existing User
		User existingUser = userService.getUser(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		
		//Save User
		userService.editUser(existingUser);
		return "redirect:/user";
	}
	
	@GetMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/user";
	}
}
