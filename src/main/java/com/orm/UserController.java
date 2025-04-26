package com.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping("/form")
	public String form() {
		return "index";
	}
	
	@Autowired
	private UserService service;
	
	@RequestMapping(path = "/handle", method = RequestMethod.POST)
	public String handle(@ModelAttribute User user, Model model) {	
		service.SaveUser(user);
		
		// Adding user name to the model to show on next page
        model.addAttribute("userName", user.getName());
        
        // After saving, redirect to success page
        return "success"; 
	}

}
