package com.sanjeep.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanjeep.jms.model.User;
import com.sanjeep.jms.repos.UserRepository;


@Controller
public class UserController {
 
	 @Autowired
	 UserRepository userRepository;
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/showRegister")
	public String showRegister() {
		return "/login/registeruser";
	}
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
		
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "/login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	 public String login(@RequestParam("email") String email, @RequestParam("password")String password, ModelMap modelMap) {
		 User user=userRepository.findByEmail(email);
		 if(user.getPassword().equals(password)) {
			 return "findFlights";
		 }else {
			 modelMap.addAttribute("msg", "Invalid username or password");
		 }
		return "login/login";
		 
	 }
}


