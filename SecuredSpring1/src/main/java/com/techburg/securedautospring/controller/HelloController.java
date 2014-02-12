package com.techburg.securedautospring.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.ui.ModelMap;

@Controller
public class HelloController {
	@RequestMapping(value="/secure/hello", method=RequestMethod.GET) 
	public String hello(ModelMap modelMap) {

		/**
		 * TODO Add context content, e.g. user name to model to be rendered on view,
		 	in order to make sure that this is a secured page
		 */
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails user = (UserDetails)principal;
			modelMap.addAttribute("authenticatedUserName", user.getUsername());
		} 
		catch(Exception e) {
			modelMap.addAttribute("authenticatedUserName", e.getMessage());
		}
		return "hello";
	}
}

