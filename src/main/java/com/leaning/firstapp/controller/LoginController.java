package com.leaning.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.leaning.firstapp.serice.LoginService;




@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String LoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String WelcomePage(ModelMap model, @RequestParam String name , @RequestParam String password) {
		if (!service.validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		else {
			model.put("name",name);
			return "welcome";
		}
		
		
	}

}
