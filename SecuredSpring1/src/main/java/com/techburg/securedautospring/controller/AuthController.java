package com.techburg.securedautospring.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequestMapping(value="/auth")

@Controller
public class AuthController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showCustomLoginPage() {
		return "login";
	}
}
