package com.security.mongo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.mongo.repository.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping( value = "/admin", method = RequestMethod.GET )
	public String admin(Model model, Principal principal)
	{
		model.addAttribute("jciUser", userService.getUserByUsername(principal.getName()));
		return "admin";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	        
}